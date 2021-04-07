package fr.azhot.weatherapp.presentation.ui.city_list

import android.content.Context
import android.location.Address
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import dagger.hilt.android.AndroidEntryPoint
import fr.azhot.weatherapp.databinding.FragmentCityListBinding
import fr.azhot.weatherapp.domain.model.City
import fr.azhot.weatherapp.domain.type.UnitsType
import java.util.*

@AndroidEntryPoint
class CityListFragment : Fragment() {

    private lateinit var binding: FragmentCityListBinding
    private val viewModel: CityListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAddressesLiveData(viewModel.addressesLiveData)
        observeCurrentWeatherLiveData(viewModel.cityLiveData)
        addTextWatcherToAutoCompleteWithTimerToFetchAddresses(binding.citySearchAutoComplete)
        setItemClickListenerToAutoComplete(binding.citySearchAutoComplete)
        // code goes here
    }


    private fun observeAddressesLiveData(liveData: LiveData<List<Address>>) {
        liveData.observe(viewLifecycleOwner) { addresses ->
            setAdapterToAutoCompleteWithAddresses(addresses)
        }
    }

    private fun setAdapterToAutoCompleteWithAddresses(addresses: List<Address>) {
        val adapter = AddressAutoCompleteAdapter(
            requireContext(),
            addresses
        )
        binding.citySearchAutoComplete.apply {
            setAdapter(adapter)
            showDropDown()
        }
    }

    private fun observeCurrentWeatherLiveData(liveData: LiveData<City>) {
        liveData.observe(viewLifecycleOwner) {
            binding.cityWeatherTextView.text = StringBuilder().run {
                appendLine("City: ${it.city}") // to be removed
                appendLine("Temperature: ${it.weatherData.current.temp.toInt()}°C") // to be removed
                appendLine("Weather condition: ${it.weatherData.current.weather[0].main}") // to be removed
                appendLine("Weather description: ${it.weatherData.current.weather[0].description}") // to be removed
                appendLine("Cloudiness: ${it.weatherData.current.clouds}%") // to be removed
                // todo: write a wind compass
                appendLine("Wind direction: ${it.weatherData.current.windDeg}°") // to be removed
                appendLine("Wind speed: ${it.weatherData.current.windSpeed} km/h") // to be removed
                toString()
            }
        }
    }

    private fun addTextWatcherToAutoCompleteWithTimerToFetchAddresses(autoCompleteTextView: AutoCompleteTextView) {
        val delay = 500L
        var timer = Timer()
        autoCompleteTextView.doAfterTextChanged { text ->
            timer.cancel()
            if (text == null || text.isEmpty()) return@doAfterTextChanged
            timer = Timer()
            timer.schedule(
                object : TimerTask() {
                    override fun run() {
                        viewModel.fetchAddresses(text.toString())
                    }
                },
                delay
            )
        }
    }

    private fun setItemClickListenerToAutoComplete(autoCompleteTextView: AutoCompleteTextView) {
        autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val item = parent.adapter.getItem(position) as Address
            viewModel.fetchWeatherData(item, UnitsType.metric)
            clearEditText(binding.citySearchAutoComplete)
            hideKeyboard()
        }
    }

    private fun clearEditText(editText: EditText) {
        editText.text?.clear()
        editText.clearFocus()
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}
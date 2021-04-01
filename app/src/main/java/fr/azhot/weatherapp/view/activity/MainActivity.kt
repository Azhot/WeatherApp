package fr.azhot.weatherapp.view.activity

import android.content.Context
import android.location.Address
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.LiveData
import dagger.hilt.android.AndroidEntryPoint
import fr.azhot.weatherapp.R
import fr.azhot.weatherapp.databinding.ActivityMainBinding
import fr.azhot.weatherapp.model.City
import fr.azhot.weatherapp.model.Units
import fr.azhot.weatherapp.view.adapter.AddressAutoCompleteAdapter
import fr.azhot.weatherapp.viewmodel.MainViewModel
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // variables
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    // overridden functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        observeAddressesLiveData(viewModel.addressesLiveData)
        observeCurrentWeatherLiveData(viewModel.cityLiveData)
        addTextWatcherToAutoCompleteWithTimerToFetchAddresses(binding.citySearchAutoComplete)
        setItemClickListenerToAutoComplete(binding.citySearchAutoComplete)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.menu, it)
            return true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.searchMenuItem -> {
                // code here starting new screen
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // functions
    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun observeAddressesLiveData(liveData: LiveData<List<Address>>) {
        liveData.observe(this) { addresses ->
            setAdapterToAutoCompleteWithAddresses(addresses)
        }
    }

    private fun setAdapterToAutoCompleteWithAddresses(addresses: List<Address>) {
        val adapter = AddressAutoCompleteAdapter(
                this,
                addresses
        )
        binding.citySearchAutoComplete.apply {
            setAdapter(adapter)
            showDropDown()
        }
    }

    private fun observeCurrentWeatherLiveData(liveData: LiveData<City>) {
        liveData.observe(this) {
            binding.cityWeatherTextView.text = StringBuilder().run {
                appendLine("City: ${it.name}") // to be removed
                appendLine("Temperature: ${it.weatherData.current.temp.toInt()}°C") // to be removed
                appendLine("Weather condition: ${it.weatherData.current.weather[0].main}") // to be removed
                appendLine("Weather description: ${it.weatherData.current.weather[0].description}") // to be removed
                appendLine("Cloudiness: ${it.weatherData.current.clouds}%") // to be removed
                // todo: write a wind compass
                appendLine("Wind direction: ${it.weatherData.current.wind_deg}°") // to be removed
                appendLine("Wind speed: ${it.weatherData.current.wind_speed} km/h") // to be removed
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
            viewModel.fetchWeatherData(item, Units.metric)
            clearEditText(binding.citySearchAutoComplete)
            hideKeyboard()
        }
    }

    private fun clearEditText(editText: EditText) {
        editText.text?.clear()
        editText.clearFocus()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}
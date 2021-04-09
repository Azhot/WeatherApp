package fr.azhot.weatherapp.presentation.ui.update_city_list

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.azhot.weatherapp.databinding.FragmentUpdateCityListBinding
import fr.azhot.weatherapp.domain.model.City
import fr.azhot.weatherapp.presentation.BaseFragment
import fr.azhot.weatherapp.presentation.MainViewModel
import java.util.*
import java.util.Collections.*

@AndroidEntryPoint
class UpdateCityListFragment :
    BaseFragment<FragmentUpdateCityListBinding>({ FragmentUpdateCityListBinding.inflate(it) }),
    UpdateCityListAdapter.Interaction {

    // variables
    private val viewModel: UpdateCityListViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var updateCityListAdapter: UpdateCityListAdapter


    // overridden functions
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
        addTextWatcherToAutoCompleteWithTimerToFetchCities()
        setItemClickListenerToAutoComplete()
    }

    override fun onCityDeleted(city: City) {
        mainViewModel.removeCity(city)
    }


    // functions
    private fun initRecyclerView() {
        binding.citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            updateCityListAdapter = UpdateCityListAdapter(this@UpdateCityListFragment)
            adapter = updateCityListAdapter
        }
    }

    private fun subscribeObservers() {
        viewModel.city.observe(viewLifecycleOwner) { city ->
            setAdapterToAutoCompleteWithFetchedCity(city)
        }

        mainViewModel.cities.observe(viewLifecycleOwner) {
            updateCityListAdapter.submitList(it.toList())
        }
    }

    private fun setAdapterToAutoCompleteWithFetchedCity(city: City) {
        val adapter = CityAutoCompleteAdapter(requireContext(), singletonList(city))
        binding.citySearchAutoComplete.apply {
            setAdapter(adapter)
            showDropDown()
        }
    }

    private fun addTextWatcherToAutoCompleteWithTimerToFetchCities() {
        val delay = 500L
        var timer = Timer()
        binding.citySearchAutoComplete.doAfterTextChanged { text ->
            timer.cancel()
            if (text == null || text.isEmpty()) return@doAfterTextChanged
            timer = Timer()
            timer.schedule(
                object : TimerTask() {
                    override fun run() {
                        viewModel.fetchCity(text.toString())
                    }
                },
                delay
            )
        }
    }

    private fun setItemClickListenerToAutoComplete() {
        binding.citySearchAutoComplete.setOnItemClickListener { parent, _, position, _ ->
            val city = parent.adapter.getItem(position) as City
            mainViewModel.addCity(city)
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
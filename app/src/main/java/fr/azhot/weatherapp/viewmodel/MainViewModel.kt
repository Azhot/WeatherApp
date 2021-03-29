package fr.azhot.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.model.autocompletePOJO.Autocomplete
import fr.azhot.weatherapp.model.currentweatherPOJO.CurrentWeather
import fr.azhot.weatherapp.repository.AutocompleteRepository
import fr.azhot.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val autocompleteRepository: AutocompleteRepository,
) : ViewModel() {

    @Inject
    lateinit var currentWeather: MutableLiveData<CurrentWeather>

    @Inject
    lateinit var autocomplete: MutableLiveData<Autocomplete>

    fun fetchCurrentWeather(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.fetchCurrentWeather(cityName).collect { response ->
                withContext(Dispatchers.Main) {
                    currentWeather.value = response
                }
            }
        }
    }

    fun fetchAutocomplete(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            autocompleteRepository.fetchAutocomplete(cityName).collect { response ->
                withContext(Dispatchers.Main) {
                    autocomplete.value = response
                }
            }
        }
    }
}
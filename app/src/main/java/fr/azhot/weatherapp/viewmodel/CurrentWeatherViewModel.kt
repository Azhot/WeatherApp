package fr.azhot.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.model.CurrentWeather
import fr.azhot.weatherapp.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    fun fetchCurrentWeather(cityName: String): LiveData<CurrentWeather> =
        weatherRepository.fetchCurrentWeather(cityName).asLiveData()

}
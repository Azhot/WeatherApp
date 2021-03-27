package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.model.CurrentWeather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun fetchCurrentWeather(cityName: String): Flow<CurrentWeather>
}


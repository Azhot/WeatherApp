package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.model.currentweatherPOJO.CurrentWeather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun fetchCurrentWeather(cityName: String): Flow<CurrentWeather>
}


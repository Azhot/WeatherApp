package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.model.Units
import fr.azhot.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun fetchWeatherData(lat: Double, lon: Double, units: Units): Flow<WeatherData>
}


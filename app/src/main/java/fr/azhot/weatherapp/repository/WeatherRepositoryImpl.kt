package fr.azhot.weatherapp.repository

import android.util.Log
import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.model.Units
import fr.azhot.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi
) : WeatherRepository {

    override suspend fun fetchWeatherData(lat: Double, lon: Double, units: Units): Flow<WeatherData> = flow {
        try {
            emit(openWeatherApi.fetchWeatherData(lat, lon, units))
        } catch (throwable: Throwable) {
            Log.e(this::class.java.simpleName, "fetchCurrentWeather: ", throwable)
        }
    }
}
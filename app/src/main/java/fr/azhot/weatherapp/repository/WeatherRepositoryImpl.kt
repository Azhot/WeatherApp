package fr.azhot.weatherapp.repository

import android.util.Log
import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.model.currentweatherPOJO.CurrentWeather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi
) : WeatherRepository {

    override suspend fun fetchCurrentWeather(cityName: String): Flow<CurrentWeather> = flow {
        try {
            emit(openWeatherApi.fetchCurrentWeather(cityName))
        } catch (throwable: Throwable) {
            Log.e(this::class.java.simpleName, "fetchCurrentWeather: ", throwable)
        }
    }
}
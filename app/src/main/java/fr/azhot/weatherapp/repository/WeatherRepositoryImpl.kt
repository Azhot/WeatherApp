package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.model.CurrentWeather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi
) : WeatherRepository {

    override fun fetchCurrentWeather(cityName: String): Flow<CurrentWeather> = flow {
        try {
            val request = openWeatherApi.fetchCurrentWeather(cityName)
            emit(request)
        } catch (throwable: Throwable) {
            println(throwable.message)
        }
    }
}
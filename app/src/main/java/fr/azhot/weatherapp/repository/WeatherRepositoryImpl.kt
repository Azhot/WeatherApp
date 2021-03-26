package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.BuildConfig
import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.model.CurrentWeather
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi
) : WeatherRepository {

    override fun getCurrentWeather(city: String): Observable<CurrentWeather> {
        return openWeatherApi.getCurrentWeather(BuildConfig.OPEN_WEATHER_API_KEY, city)
    }
}
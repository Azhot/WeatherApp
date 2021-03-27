package fr.azhot.weatherapp.api

import fr.azhot.weatherapp.BuildConfig
import fr.azhot.weatherapp.model.CurrentWeather
import fr.azhot.weatherapp.utils.QUERY_CURRENT_WEATHER
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {

    /**
     * A Retrofit GET request to the Open Weather - Current Weather - API.
     */
    @GET(QUERY_CURRENT_WEATHER)
    suspend fun fetchCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = BuildConfig.OPEN_WEATHER_API_KEY,
    ): CurrentWeather
}
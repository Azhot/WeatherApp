package fr.azhot.weatherapp.api

import fr.azhot.weatherapp.BuildConfig
import fr.azhot.weatherapp.model.Units
import fr.azhot.weatherapp.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {

    /**
     * A Retrofit GET request to the Open Weather API.
     */
    @GET("data/2.5/onecall?appid=" + BuildConfig.OPEN_WEATHER_API_KEY)
    suspend fun fetchWeatherData(
            @Query("lat") lat: Double,
            @Query("lon") lon: Double,
            @Query("units") units: Units,
    ): WeatherData
}
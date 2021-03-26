package fr.azhot.weatherapp.api

import fr.azhot.weatherapp.model.CurrentWeather
import fr.azhot.weatherapp.utils.QUERY_CURRENT_WEATHER
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {

    /**
     * A Retrofit GET request to the Open Weather - Current Weather - API.
     */
    @GET(QUERY_CURRENT_WEATHER)
    fun getCurrentWeather(
        @Query("appid") apiKey: String,
        @Query("q") city: String,
    ): Observable<CurrentWeather>
}
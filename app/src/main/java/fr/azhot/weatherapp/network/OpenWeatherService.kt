package fr.azhot.weatherapp.network

import androidx.lifecycle.LiveData
import fr.azhot.weatherapp.BuildConfig
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.network.model.ForecastDto
import fr.azhot.weatherapp.network.util.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {

    /**
     * A Retrofit GET request to the Open Weather API.
     */
    @GET("onecall?appid=" + BuildConfig.OPEN_WEATHER_API_KEY)
    fun fetchForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: UnitsType,
    ): LiveData<ApiResponse<ForecastDto>>
}
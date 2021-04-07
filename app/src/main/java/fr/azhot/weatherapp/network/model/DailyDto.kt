package fr.azhot.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyDto(
    @Expose
    @SerializedName("clouds")
    val clouds: Int,
    @Expose
    @SerializedName("dew_point")
    val dew_point: Double,
    @Expose
    @SerializedName("dt")
    val dt: Int,
    @Expose
    @SerializedName("feels_like")
    val feels_like: FeelsLikeDto,
    @Expose
    @SerializedName("humidity")
    val humidity: Int,
    @Expose
    @SerializedName("pop")
    val pop: Double,
    @Expose
    @SerializedName("pressure")
    val pressure: Int,
    @Expose
    @SerializedName("rain")
    val rain: Double,
    @Expose
    @SerializedName("snow")
    val snow: Double,
    @Expose
    @SerializedName("sunrise")
    val sunrise: Int,
    @Expose
    @SerializedName("sunset")
    val sunset: Int,
    @Expose
    @SerializedName("temp")
    val temp: TempDto,
    @Expose
    @SerializedName("uvi")
    val uvi: Double,
    @Expose
    @SerializedName("weather")
    val weather: List<WeatherDto>,
    @Expose
    @SerializedName("wind_deg")
    val wind_deg: Int,
    @Expose
    @SerializedName("wind_speed")
    val wind_speed: Double
)
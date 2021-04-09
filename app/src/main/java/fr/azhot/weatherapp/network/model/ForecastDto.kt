package fr.azhot.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @Expose
    @SerializedName("alerts")
    val alerts: List<AlertDto>? = null,
    @Expose
    @SerializedName("current")
    val current: CurrentDto,
    @Expose
    @SerializedName("daily")
    val daily: List<DailyDto>,
    @Expose
    @SerializedName("hourly")
    val hourly: List<HourlyDto>,
    @Expose
    @SerializedName("lat")
    val lat: Double,
    @Expose
    @SerializedName("lon")
    val lon: Double,
    @Expose
    @SerializedName("minutely")
    val minutely: List<MinutelyDto>,
    @Expose
    @SerializedName("timezone")
    val timezone: String,
    @Expose
    @SerializedName("timezone_offset")
    val timezone_offset: Int
)
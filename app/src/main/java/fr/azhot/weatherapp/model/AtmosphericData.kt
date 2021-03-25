package fr.azhot.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AtmosphericData(
    @SerializedName("temp")
    @Expose
    // Kelvin
    var temperature: Double = 0.0,
    @SerializedName("feelsLike")
    @Expose
    // Kelvin - this temperature parameter accounts for the human perception of weather
    var feelsLike: Double = 0.0,
    @SerializedName("tempMin")
    @Expose
    // Kelvin
    var minTemperature: Double = 0.0,
    @SerializedName("tempMax")
    @Expose
    // Kelvin
    var maxTemperature: Double = 0.0,
    @SerializedName("pressure")
    @Expose
    // hPa
    var pressure: Int = 0,
    @SerializedName("humidity")
    @Expose
    // percentage
    var humidity: Int = 0,
)
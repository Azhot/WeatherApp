package fr.azhot.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * POJO class for a call to the openweathermap.org API
 */

data class Weather(
    @SerializedName("id")
    @Expose
    var id: Int = 0,
    @SerializedName("main")
    @Expose
    var condition: String = "",
    @SerializedName("description")
    @Expose
    var description: String = "",
    @SerializedName("icon")
    @Expose
    // weather icon id to be loaded from http://openweathermap.org/img/wn/{icon}.png
    var icon: String = "",
)
package fr.azhot.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    @Expose
    // meter/sec
    var speed: Double = 0.0,
    @SerializedName("deg")
    @Expose
    // degree
    var direction: Int = 0,
)
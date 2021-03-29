package fr.azhot.weatherapp.model.currentweatherPOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lon")
    @Expose
    var longitude: Double = 0.0,
    @SerializedName("lat")
    @Expose
    var latitude: Double = 0.0,
)
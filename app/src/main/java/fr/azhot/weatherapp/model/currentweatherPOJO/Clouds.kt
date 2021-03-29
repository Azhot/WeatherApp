package fr.azhot.weatherapp.model.currentweatherPOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    @Expose
    // percentage
    var cloudiness: Int = 0,
)
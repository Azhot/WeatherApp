package fr.azhot.weatherapp.model.currentweatherPOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(
    // Country code (GB, JP etc.)
    var country: String = "",
    @SerializedName("sunrise")
    @Expose
    // Sunrise time, unix, UTC
    var sunrise: Int = 0,
    @SerializedName("sunset")
    @Expose
    // Sunset time, unix, UTC
    var sunset: Int = 0,
)
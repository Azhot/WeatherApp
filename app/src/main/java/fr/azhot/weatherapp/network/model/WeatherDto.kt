package fr.azhot.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("icon")
    val icon: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("main")
    val main: String
)
package fr.azhot.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MinutelyDto(
    @Expose
    @SerializedName("dt")
    val dt: Int,
    @Expose
    @SerializedName("precipitation")
    val precipitation: Int
)
package fr.azhot.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FeelsLikeDto(
    @Expose
    @SerializedName("day")
    val day: Double,
    @Expose
    @SerializedName("eve")
    val eve: Double,
    @Expose
    @SerializedName("morn")
    val morn: Double,
    @Expose
    @SerializedName("night")
    val night: Double
)
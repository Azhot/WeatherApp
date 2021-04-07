package fr.azhot.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlertDto(
    @Expose
    @SerializedName("sender_name")
    val sender_name: String,
    @Expose
    @SerializedName("event")
    val event: String,
    @Expose
    @SerializedName("start")
    val start: Int,
    @Expose
    @SerializedName("end")
    val end: Int,
    @Expose
    @SerializedName("description")
    val description: String,
)
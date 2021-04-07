package fr.azhot.weatherapp.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Alert(
    val senderName: String,
    val event: String,
    val start: Int,
    val end: Int,
    val description: String,
)
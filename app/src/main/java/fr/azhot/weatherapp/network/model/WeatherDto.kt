package fr.azhot.weatherapp.network.model

data class WeatherDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)
package fr.azhot.weatherapp.network.model

data class FeelsLikeDto(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
)
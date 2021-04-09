package fr.azhot.weatherapp.domain.model

data class Forecast(
    val alerts: List<Alert>? = null,
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
)
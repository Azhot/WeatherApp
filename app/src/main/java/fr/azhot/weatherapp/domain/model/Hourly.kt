package fr.azhot.weatherapp.domain.model

data class Hourly(
    val clouds: Int,
    val dewPoint: Double,
    val dt: Int,
    val feelsLike: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val temp: Double,
    val uvi: Double,
    val visibility: Int,
    val weather: List<Weather>,
    val windDeg: Int,
    val windGust: Double,
    val windSpeed: Double
)
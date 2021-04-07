package fr.azhot.weatherapp.domain.model

data class Daily(
    val clouds: Int,
    val dewPoint: Double,
    val dt: Int,
    val feelsLike: FeelsLike,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val snow: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val uvi: Double,
    val weather: List<Weather>,
    val windDeg: Int,
    val windSpeed: Double
)
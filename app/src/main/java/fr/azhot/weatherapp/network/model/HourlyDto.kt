package fr.azhot.weatherapp.network.model

data class HourlyDto(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val temp: Double,
    val uvi: Double,
    val visibility: Int,
    val weather: List<WeatherDto>,
    val wind_deg: Int,
    val wind_gust: Double,
    val wind_speed: Double
)
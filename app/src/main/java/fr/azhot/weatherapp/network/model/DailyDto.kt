package fr.azhot.weatherapp.network.model

data class DailyDto(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: FeelsLikeDto,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val snow: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempDto,
    val uvi: Double,
    val weather: List<WeatherDto>,
    val wind_deg: Int,
    val wind_speed: Double
)
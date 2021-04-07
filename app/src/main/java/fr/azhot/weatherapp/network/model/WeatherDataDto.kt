package fr.azhot.weatherapp.network.model

data class WeatherDataDto(
    val alerts: List<Any>,
    val current: CurrentDto,
    val daily: List<DailyDto>,
    val hourly: List<HourlyDto>,
    val lat: Double,
    val lon: Double,
    val minutely: List<MinutelyDto>,
    val timezone: String,
    val timezone_offset: Int
)
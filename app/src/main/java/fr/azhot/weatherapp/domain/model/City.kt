package fr.azhot.weatherapp.domain.model

data class City(
    val city: String,
    val country: String,
    val weatherData: WeatherData
)
package fr.azhot.weatherapp.domain.model

import fr.azhot.weatherapp.network.model.WeatherDto

data class City(
        val city: String,
        val country: String,
        val weatherDto: WeatherDto
)
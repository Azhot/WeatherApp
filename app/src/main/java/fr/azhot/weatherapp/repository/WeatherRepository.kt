package fr.azhot.weatherapp.repository

import android.location.Address
import fr.azhot.weatherapp.domain.model.City
import fr.azhot.weatherapp.domain.model.WeatherData
import fr.azhot.weatherapp.domain.type.UnitsType

interface WeatherRepository {
    suspend fun fetchWeatherData(
        address: Address,
        units: UnitsType,
    ): WeatherData
}


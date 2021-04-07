package fr.azhot.weatherapp.repository

import android.location.Address
import fr.azhot.weatherapp.domain.model.WeatherData
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.network.OpenWeatherService
import fr.azhot.weatherapp.network.model.WeatherDataDtoMapper

class WeatherRepositoryImpl(
    private val openWeatherService: OpenWeatherService,
    private val weatherDataDtoMapper: WeatherDataDtoMapper,
) : WeatherRepository {

    override suspend fun fetchWeatherData(
        address: Address,
        units: UnitsType,
    ): WeatherData {
        return weatherDataDtoMapper.mapToDomain(
            openWeatherService.fetchWeatherData(
                address.latitude,
                address.longitude,
                units
            )
        )
    }
}
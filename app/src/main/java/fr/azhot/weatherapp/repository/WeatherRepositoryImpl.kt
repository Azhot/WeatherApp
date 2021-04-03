package fr.azhot.weatherapp.repository

import android.location.Address
import fr.azhot.weatherapp.domain.model.City
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.network.OpenWeatherService
import fr.azhot.weatherapp.network.model.WeatherDtoMapper

class WeatherRepositoryImpl(
    private val openWeatherService: OpenWeatherService,
    private val weatherDtoMapper: WeatherDtoMapper,
) : WeatherRepository {

    override suspend fun fetchWeatherData(
        address: Address,
        units: UnitsType,
    ): City {
        return weatherDtoMapper.mapToDomain(
            address,
            openWeatherService.fetchWeatherData(
                address.latitude,
                address.longitude,
                units
            )
        )
    }
}
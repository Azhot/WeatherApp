package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Weather
import fr.azhot.weatherapp.domain.util.DomainMapper

object WeatherDtoMapper : DomainMapper<WeatherDto, Weather> {
    override fun mapToDomain(model: WeatherDto): Weather {
        return Weather(
            description = model.description,
            icon = model.icon,
            id = model.id,
            main = model.main
        )
    }

    override fun mapFromDomain(domainModel: Weather): WeatherDto {
        return WeatherDto(
            description = domainModel.description,
            icon = domainModel.icon,
            id = domainModel.id,
            main = domainModel.main
        )
    }

    fun mapToDomainList(models: List<WeatherDto>): List<Weather> {
        return models.map { mapToDomain(it) }
    }

    fun mapFromDomainList(domainModels: List<Weather>): List<WeatherDto> {
        return domainModels.map { mapFromDomain(it) }
    }
}
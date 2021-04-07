package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Hourly
import fr.azhot.weatherapp.domain.util.DomainMapper

object HourlyDtoMapper : DomainMapper<HourlyDto, Hourly> {
    override fun mapToDomain(model: HourlyDto): Hourly {
        return Hourly(
            clouds = model.clouds,
            dewPoint = model.dew_point,
            dt = model.dt,
            feelsLike = model.feels_like,
            humidity = model.humidity,
            pop = model.pop,
            pressure = model.pressure,
            temp = model.temp,
            uvi = model.uvi,
            visibility = model.visibility,
            weather = WeatherDtoMapper.mapToDomainList(model.weather),
            windDeg = model.wind_deg,
            windGust = model.wind_gust,
            windSpeed = model.wind_speed,
        )
    }

    override fun mapFromDomain(domainModel: Hourly): HourlyDto {
        return HourlyDto(
            clouds = domainModel.clouds,
            dew_point = domainModel.dewPoint,
            dt = domainModel.dt,
            feels_like = domainModel.feelsLike,
            humidity = domainModel.humidity,
            pop = domainModel.pop,
            pressure = domainModel.pressure,
            temp = domainModel.temp,
            uvi = domainModel.uvi,
            visibility = domainModel.visibility,
            weather = WeatherDtoMapper.mapFromDomainList(domainModel.weather),
            wind_deg = domainModel.windDeg,
            wind_gust = domainModel.windGust,
            wind_speed = domainModel.windSpeed,
        )
    }

    fun mapToDomainList(models: List<HourlyDto>): List<Hourly> {
        return models.map { mapToDomain(it) }
    }

    fun mapFromDomainList(models: List<Hourly>): List<HourlyDto> {
        return models.map { mapFromDomain(it) }
    }
}
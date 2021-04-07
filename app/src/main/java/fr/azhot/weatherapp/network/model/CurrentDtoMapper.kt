package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Current
import fr.azhot.weatherapp.domain.util.DomainMapper

object CurrentDtoMapper : DomainMapper<CurrentDto, Current> {
    override fun mapToDomain(model: CurrentDto): Current {
        return Current(
            clouds = model.clouds,
            dewPoint = model.dew_point,
            dt = model.dt,
            feelsLike = model.feels_like,
            humidity = model.humidity,
            pressure = model.pressure,
            sunrise = model.sunrise,
            sunset = model.sunset,
            temp = model.temp,
            uvi = model.uvi,
            visibility = model.visibility,
            weather = WeatherDtoMapper.mapToDomainList(model.weather),
            windDeg = model.wind_deg,
            windGust = model.wind_gust,
            windSpeed = model.wind_speed,
        )
    }

    override fun mapFromDomain(domainModel: Current): CurrentDto {
        return CurrentDto(
            clouds = domainModel.clouds,
            dew_point = domainModel.dewPoint,
            dt = domainModel.dt,
            feels_like = domainModel.feelsLike,
            humidity = domainModel.humidity,
            pressure = domainModel.pressure,
            sunrise = domainModel.sunrise,
            sunset = domainModel.sunset,
            temp = domainModel.temp,
            uvi = domainModel.uvi,
            visibility = domainModel.visibility,
            weather = WeatherDtoMapper.mapFromDomainList(domainModel.weather),
            wind_deg = domainModel.windDeg,
            wind_gust = domainModel.windGust,
            wind_speed = domainModel.windSpeed,
        )
    }
}
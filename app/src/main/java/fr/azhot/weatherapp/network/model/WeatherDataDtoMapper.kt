package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.WeatherData
import fr.azhot.weatherapp.domain.util.DomainMapper

object WeatherDataDtoMapper : DomainMapper<WeatherDataDto, WeatherData> {
    override fun mapToDomain(model: WeatherDataDto): WeatherData {
        return WeatherData(
            alerts = AlertDtoMapper.mapToDomainList(model.alerts),
            current = CurrentDtoMapper.mapToDomain(model.current),
            daily = DailyDtoMapper.mapToDomainList(model.daily),
            hourly = HourlyDtoMapper.mapToDomainList(model.hourly),
            lat = model.lat,
            lon = model.lon,
            minutely = MinutelyDtoMapper.mapToDomainList(model.minutely),
            timezone = model.timezone,
            timezone_offset = model.timezone_offset
        )
    }

    override fun mapFromDomain(domainModel: WeatherData): WeatherDataDto {
        return WeatherDataDto(
            alerts = AlertDtoMapper.mapFromDomainList(domainModel.alerts),
            current = CurrentDtoMapper.mapFromDomain(domainModel.current),
            daily = DailyDtoMapper.mapFromDomainList(domainModel.daily),
            hourly = HourlyDtoMapper.mapFromDomainList(domainModel.hourly),
            lat = domainModel.lat,
            lon = domainModel.lon,
            minutely = MinutelyDtoMapper.mapFromDomainList(domainModel.minutely),
            timezone = domainModel.timezone,
            timezone_offset = domainModel.timezone_offset
        )
    }

}
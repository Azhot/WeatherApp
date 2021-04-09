package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Forecast
import fr.azhot.weatherapp.domain.util.DomainMapper

object ForecastDtoMapper : DomainMapper<ForecastDto, Forecast> {
    override fun mapToDomain(model: ForecastDto): Forecast {
        return Forecast(
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

    override fun mapFromDomain(domainModel: Forecast): ForecastDto {
        return ForecastDto(
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
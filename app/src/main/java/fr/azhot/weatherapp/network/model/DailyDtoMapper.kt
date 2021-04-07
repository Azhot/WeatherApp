package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Daily
import fr.azhot.weatherapp.domain.util.DomainMapper

object DailyDtoMapper : DomainMapper<DailyDto, Daily> {
    override fun mapToDomain(model: DailyDto): Daily {
        return Daily(
            clouds = model.clouds,
            dewPoint = model.dew_point,
            dt = model.dt,
            feelsLike = FeelsLikeDtoMapper.mapToDomain(model.feels_like),
            humidity = model.humidity,
            pop = model.pop,
            pressure = model.pressure,
            rain = model.rain,
            snow = model.snow,
            sunrise = model.sunrise,
            sunset = model.sunset,
            temp = TempDtoMapper.mapToDomain(model.temp),
            uvi = model.uvi,
            weather = WeatherDtoMapper.mapToDomainList(model.weather),
            windDeg = model.wind_deg,
            windSpeed = model.wind_speed,
        )
    }

    override fun mapFromDomain(domainModel: Daily): DailyDto {
        return DailyDto(
            clouds = domainModel.clouds,
            dew_point = domainModel.dewPoint,
            dt = domainModel.dt,
            feels_like = FeelsLikeDtoMapper.mapFromDomain(domainModel.feelsLike),
            humidity = domainModel.humidity,
            pop = domainModel.pop,
            pressure = domainModel.pressure,
            rain = domainModel.rain,
            snow = domainModel.snow,
            sunrise = domainModel.sunrise,
            sunset = domainModel.sunset,
            temp = TempDtoMapper.mapFromDomain(domainModel.temp),
            uvi = domainModel.uvi,
            weather = WeatherDtoMapper.mapFromDomainList(domainModel.weather),
            wind_deg = domainModel.windDeg,
            wind_speed = domainModel.windSpeed,
        )
    }

    fun mapToDomainList(models: List<DailyDto>): List<Daily> {
        return models.map { mapToDomain(it) }
    }

    fun mapFromDomainList(models: List<Daily>): List<DailyDto> {
        return models.map { mapFromDomain(it) }
    }
}
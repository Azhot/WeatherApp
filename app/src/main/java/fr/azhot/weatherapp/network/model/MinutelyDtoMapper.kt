package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Minutely
import fr.azhot.weatherapp.domain.util.DomainMapper

object MinutelyDtoMapper : DomainMapper<MinutelyDto, Minutely> {
    override fun mapToDomain(model: MinutelyDto): Minutely {
        return Minutely(
            dt = model.dt,
            precipitation = model.precipitation
        )
    }

    override fun mapFromDomain(domainModel: Minutely): MinutelyDto {
        return MinutelyDto(
            dt = domainModel.dt,
            precipitation = domainModel.precipitation
        )
    }

    fun mapToDomainList(models: List<MinutelyDto>): List<Minutely> {
        return models.map { mapToDomain(it) }
    }

    fun mapFromDomainList(models: List<Minutely>): List<MinutelyDto> {
        return models.map { mapFromDomain(it) }
    }
}
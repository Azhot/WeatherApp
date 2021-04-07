package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Temp
import fr.azhot.weatherapp.domain.util.DomainMapper

object TempDtoMapper : DomainMapper<TempDto, Temp> {
    override fun mapToDomain(model: TempDto): Temp {
        return Temp(
            day = model.day,
            eve = model.eve,
            max = model.max,
            min = model.min,
            morn = model.morn,
            night = model.night,
        )
    }

    override fun mapFromDomain(domainModel: Temp): TempDto {
        return TempDto(
            day = domainModel.day,
            eve = domainModel.eve,
            max = domainModel.max,
            min = domainModel.min,
            morn = domainModel.morn,
            night = domainModel.night,
        )
    }
}
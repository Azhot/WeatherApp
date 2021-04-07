package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.FeelsLike
import fr.azhot.weatherapp.domain.util.DomainMapper

object FeelsLikeDtoMapper : DomainMapper<FeelsLikeDto, FeelsLike> {
    override fun mapToDomain(model: FeelsLikeDto): FeelsLike {
        return FeelsLike(
            day = model.day,
            eve = model.eve,
            morn = model.morn,
            night = model.night,
        )
    }

    override fun mapFromDomain(domainModel: FeelsLike): FeelsLikeDto {
        return FeelsLikeDto(
            day = domainModel.day,
            eve = domainModel.eve,
            morn = domainModel.morn,
            night = domainModel.night,
        )
    }
}
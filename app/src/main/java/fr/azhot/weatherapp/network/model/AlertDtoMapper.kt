package fr.azhot.weatherapp.network.model

import fr.azhot.weatherapp.domain.model.Alert
import fr.azhot.weatherapp.domain.util.DomainMapper

object AlertDtoMapper : DomainMapper<AlertDto, Alert> {
    override fun mapToDomain(model: AlertDto): Alert {
        return Alert(
            senderName = model.sender_name,
            event = model.event,
            start = model.start,
            end = model.end,
            description = model.description
        )
    }

    override fun mapFromDomain(domainModel: Alert): AlertDto {
        return AlertDto(
            sender_name = domainModel.senderName,
            event = domainModel.event,
            start = domainModel.start,
            end = domainModel.end,
            description = domainModel.description
        )
    }

    fun mapToDomainList(models: List<AlertDto>): List<Alert> {
        return models.map { mapToDomain(it) }
    }

    fun mapFromDomainList(domainModels: List<Alert>): List<AlertDto> {
        return domainModels.map { mapFromDomain(it) }
    }
}
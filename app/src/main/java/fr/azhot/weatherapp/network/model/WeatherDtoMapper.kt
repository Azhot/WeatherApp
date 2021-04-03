package fr.azhot.weatherapp.network.model

import android.location.Address
import fr.azhot.weatherapp.domain.model.City

class WeatherDtoMapper {

    fun mapToDomain(address: Address, model: WeatherDto): City {
        return City(
            city = address.locality,
            country = address.countryName,
            weatherDto = model
        )
    }

    fun mapFromDomain(domainModel: City): WeatherDto {
        return domainModel.weatherDto
    }
}
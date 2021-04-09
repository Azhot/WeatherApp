package fr.azhot.weatherapp.presentation.ui.city_list.state

import fr.azhot.weatherapp.domain.type.UnitsType

sealed class CityListStateEvent {

    class GetForecastEvent(
        val lat: Double,
        val lon: Double,
        val units: UnitsType,
    ) : CityListStateEvent()

    object None : CityListStateEvent()
}
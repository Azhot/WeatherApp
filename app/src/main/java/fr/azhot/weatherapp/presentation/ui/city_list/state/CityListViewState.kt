package fr.azhot.weatherapp.presentation.ui.city_list.state

import fr.azhot.weatherapp.domain.model.Forecast

data class CityListViewState(
    var forecast: Forecast? = null,
)
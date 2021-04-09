package fr.azhot.weatherapp.repository

import androidx.lifecycle.LiveData
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListViewState
import fr.azhot.weatherapp.util.DataState

interface WeatherRepository {
    fun fetchForecast(
        lat: Double,
        lon: Double,
        units: UnitsType,
    ): LiveData<DataState<CityListViewState>>
}


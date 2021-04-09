package fr.azhot.weatherapp.repository

import androidx.lifecycle.LiveData
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.network.OpenWeatherService
import fr.azhot.weatherapp.network.model.ForecastDto
import fr.azhot.weatherapp.network.model.ForecastDtoMapper
import fr.azhot.weatherapp.network.util.ApiResponse
import fr.azhot.weatherapp.network.util.ApiSuccessResponse
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListViewState
import fr.azhot.weatherapp.util.DataState

class WeatherRepositoryImpl(
    private val openWeatherService: OpenWeatherService,
    private val weatherDataDtoMapper: ForecastDtoMapper,
) : WeatherRepository {

    override fun fetchForecast(
        lat: Double,
        lon: Double,
        units: UnitsType,
    ): LiveData<DataState<CityListViewState>> {
        return object : NetworkBoundResource<ForecastDto, CityListViewState>() {
            override fun createCall(): LiveData<ApiResponse<ForecastDto>> {
                return openWeatherService.fetchForecast(lat, lon, units)
            }

            override fun handleApiSuccessResponse(response: ApiSuccessResponse<ForecastDto>) {
                result.value = DataState.data(
                    data = CityListViewState(weatherDataDtoMapper.mapToDomain(response.body))
                )
            }
        }.asLiveData()
    }
}
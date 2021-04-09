package fr.azhot.weatherapp.presentation.ui.city_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.domain.model.Forecast
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListStateEvent
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListStateEvent.GetForecastEvent
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListStateEvent.None
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListViewState
import fr.azhot.weatherapp.repository.WeatherRepository
import fr.azhot.weatherapp.util.AbsentLiveData
import fr.azhot.weatherapp.util.DataState
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    application: Application,
) : AndroidViewModel(application) {

    private val _stateEvent: MutableLiveData<CityListStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<CityListViewState> = MutableLiveData()

    val viewState: LiveData<CityListViewState>
        get() = _viewState

    val dataState: LiveData<DataState<CityListViewState>> = Transformations
        .switchMap(_stateEvent) { stateEvent ->
            stateEvent?.let {
                handleStateEvent(stateEvent)
            }
        }

    private fun handleStateEvent(stateEvent: CityListStateEvent): LiveData<DataState<CityListViewState>> {
        return when (stateEvent) {
            is GetForecastEvent -> {
                weatherRepository.fetchForecast(stateEvent.lat, stateEvent.lon, stateEvent.units)
            }
            is None -> {
                AbsentLiveData.create()
            }
        }
    }

    fun setForecastData(forecast: Forecast) {
        val update = getCurrentViewStateOrNew()
        update.forecast = forecast
        _viewState.value = update
    }

    fun getCurrentViewStateOrNew(): CityListViewState {
        return viewState.value ?: CityListViewState()
    }

    fun setStateEvent(event: CityListStateEvent) {
        _stateEvent.value = event
    }
}
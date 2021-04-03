package fr.azhot.weatherapp.presentation.ui.city_list

import android.app.Application
import android.location.Address
import android.location.Geocoder
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.domain.model.City
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    application: Application,
) : AndroidViewModel(application) {

    @Inject
    lateinit var geocoder: Geocoder

    @Inject
    lateinit var _addressesLiveData: MutableLiveData<List<Address>>

    @Inject
    lateinit var _cityLiveData: MutableLiveData<City>

    val addressesLiveData: LiveData<List<Address>> get() = _addressesLiveData
    val cityLiveData: LiveData<City> get() = _cityLiveData


    fun fetchWeatherData(address: Address, units: UnitsType) {
        viewModelScope.launch {
            _cityLiveData.value = withContext(Dispatchers.IO) {
                weatherRepository.fetchWeatherData(address, units)
            }
        }
    }

    fun fetchAddresses(cityName: String) {
        viewModelScope.launch {
            runCatching {
                _addressesLiveData.value = withContext(Dispatchers.IO) {
                    geocoder.getFromLocationName(cityName, 5)
                }
            }.run {
                if (this.isFailure)
                    Log.e(
                        CityListViewModel::class.simpleName,
                        "fetchAddresses: ",
                        this.exceptionOrNull()
                    )
            }
        }
    }
}
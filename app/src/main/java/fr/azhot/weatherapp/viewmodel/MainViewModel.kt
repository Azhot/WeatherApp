package fr.azhot.weatherapp.viewmodel

import android.app.Application
import android.location.Address
import android.location.Geocoder
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.model.City
import fr.azhot.weatherapp.model.Units
import fr.azhot.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
        private val weatherRepository: WeatherRepository,
        application: Application,
) : AndroidViewModel(application) {

    @Inject
    lateinit var cityLiveData: MutableLiveData<City>

    @Inject
    lateinit var addressesLiveData: MutableLiveData<List<Address>>

    fun fetchWeatherData(address: Address, units: Units) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.fetchWeatherData(
                    address.latitude,
                    address.longitude,
                    units).collect { response ->
                withContext(Dispatchers.Main) {
                    cityLiveData.value = City(address.locality, address.countryName, response)
                }
            }
        }
    }

    fun fetchAddresses(cityName: String) {
        val geocoder = Geocoder(getApplication())
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val addresses = geocoder.getFromLocationName(cityName, 5)
                withContext(Dispatchers.Main) {
                    addressesLiveData.value = addresses
                }
            }.run {
                if (this.isFailure)
                    Log.e(
                            MainViewModel::class.simpleName,
                            "fetchAddresses: ",
                            this.exceptionOrNull()
                    )
            }
        }
    }
}
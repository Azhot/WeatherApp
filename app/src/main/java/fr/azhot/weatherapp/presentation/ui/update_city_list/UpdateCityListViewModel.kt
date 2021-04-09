package fr.azhot.weatherapp.presentation.ui.update_city_list

import android.app.Application
import android.location.Geocoder
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.domain.model.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UpdateCityListViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {

    private val geocoder: Geocoder = Geocoder(application)
    private val _city: MutableLiveData<City> = MutableLiveData()
    val city: LiveData<City> get() = _city

    fun fetchCity(cityName: String) {
        viewModelScope.launch {
            runCatching {
                val address = withContext(Dispatchers.IO) {
                    geocoder.getFromLocationName(cityName, 1)
                }
                if (address.isNotEmpty())
                    _city.value = City(address[0].locality, address[0].countryName)
            }.run {
                if (this.isFailure)
                    Log.e(
                        UpdateCityListViewModel::class.simpleName,
                        "fetchCity: ",
                        this.exceptionOrNull()
                    )
            }
        }
    }
}
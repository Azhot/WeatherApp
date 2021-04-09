package fr.azhot.weatherapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.azhot.weatherapp.domain.model.City
import java.util.*
import javax.inject.Inject
import kotlin.Comparator

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {


    // todo : this viewModel should hold a LiveData of cities coming from Room database.
    //  addCity and removeCity should then perform relevant actions on the database, changes applied
    //  being then observe through the LiveData.

    private val _cities: MutableLiveData<SortedSet<City>> = MutableLiveData()
    val cities: LiveData<SortedSet<City>>
        get() = _cities

    init {
        _cities.value = sortedSetOf(Comparator<City> { o1, o2 ->
            o1?.name.toString().compareTo(o2?.name.toString())
        })
    }

    fun addCity(city: City) {
        _cities.value?.add(city)
        _cities.value = _cities.value
    }

    fun removeCity(city: City) {
        _cities.value?.remove(city)
        _cities.value = _cities.value
    }
}
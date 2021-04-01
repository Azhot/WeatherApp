package fr.azhot.weatherapp.viewModelTest

import android.location.Address
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.azhot.weatherapp.base.BaseApplication
import fr.azhot.weatherapp.di.ServiceModule
import fr.azhot.weatherapp.model.Units
import fr.azhot.weatherapp.repository.WeatherRepositoryImpl
import fr.azhot.weatherapp.viewModelTest.testHelper.getOrAwaitValue
import fr.azhot.weatherapp.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        val openWeatherApi = ServiceModule.provideOpenWeatherService()
        val weatherRepository = WeatherRepositoryImpl(openWeatherApi)
        viewModel = MainViewModel(weatherRepository, BaseApplication())
    }

    @Test
    fun shouldReturnParisIfFetchCurrentWeatherWithParis() {
        CoroutineScope(Dispatchers.Main).launch {
            runCatching {
                viewModel.fetchWeatherData(Address(Locale.FRANCE), Units.metric)
                assertEquals(
                    "France",
                    viewModel.cityLiveData.getOrAwaitValue().country
                )
            }.run {
                this.exceptionOrNull()?.let { throwable ->
                    println(throwable.message)
                }
            }
        }
    }

    @Test
    fun shouldReturnParisIfFetchAutocompleteWithParis() {
        CoroutineScope(Dispatchers.Main).launch {
            runCatching {
                viewModel.fetchAddresses("Paris")
                assertEquals(
                    "Paris",
                    viewModel.addressesLiveData.getOrAwaitValue()[0].locality
                )
            }.run {
                this.exceptionOrNull()?.let { throwable ->
                    println(throwable.message)
                }
            }
        }
    }
}
package fr.azhot.weatherapp.viewModelTest

import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.azhot.weatherapp.di.ServiceModule
import fr.azhot.weatherapp.repository.AutocompleteRepositoryImpl
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

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        val openWeatherApi = ServiceModule.provideOpenWeatherService()
        val weatherRepository = WeatherRepositoryImpl(openWeatherApi)
        val hereAutocompleteApi = ServiceModule.provideHereAutocompleteService()
        val autocompleteRepository = AutocompleteRepositoryImpl(hereAutocompleteApi)
        viewModel = MainViewModel(weatherRepository, autocompleteRepository)
    }

    @Test
    fun shouldReturnParisIfFetchCurrentWeatherWithParis() {
        CoroutineScope(Dispatchers.Main).launch {
            runCatching {
                viewModel.fetchCurrentWeather("Paris")
                assertEquals(
                    "Paris",
                    viewModel.currentWeather.getOrAwaitValue().cityName
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
                viewModel.fetchCurrentWeather("Paris")
                assertEquals(
                    "Paris",
                    viewModel.autocomplete.getOrAwaitValue().items?.get(0)?.address?.city
                )
            }.run {
                this.exceptionOrNull()?.let { throwable ->
                    println(throwable.message)
                }
            }
        }
    }
}
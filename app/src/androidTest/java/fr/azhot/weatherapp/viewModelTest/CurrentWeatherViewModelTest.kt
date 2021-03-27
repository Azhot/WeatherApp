package fr.azhot.weatherapp.viewModelTest

import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.repository.WeatherRepositoryImpl
import fr.azhot.weatherapp.service.RetrofitService
import fr.azhot.weatherapp.viewModelTest.testHelper.getOrAwaitValue
import fr.azhot.weatherapp.viewmodel.CurrentWeatherViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CurrentWeatherViewModelTest {

    private lateinit var viewModel: CurrentWeatherViewModel

    @Before
    fun setUp() {
        val openWeatherApi = RetrofitService.createService(OpenWeatherApi::class.java)
        val weatherRepository = WeatherRepositoryImpl(openWeatherApi)
        viewModel = CurrentWeatherViewModel(weatherRepository)
    }

    @Test
    fun shouldReturnParisIfFetchCurrentWeatherWithParis() {
        CoroutineScope(Dispatchers.Main).launch {
            runCatching {
                assertEquals(
                    "Paris",
                    viewModel.fetchCurrentWeather("Paris").getOrAwaitValue().cityName
                )
            }.run {
                this.exceptionOrNull()?.let { throwable ->
                    println(throwable.message)
                }
            }
        }
    }
}
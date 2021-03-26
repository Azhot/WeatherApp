package fr.azhot.weatherapp.repositoryTest

import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.model.CurrentWeather
import fr.azhot.weatherapp.repository.WeatherRepository
import fr.azhot.weatherapp.repository.WeatherRepositoryImpl
import io.reactivex.Observable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class WeatherRepositoryTest {

    @Mock
    lateinit var openWeatherApi: OpenWeatherApi
    lateinit var weatherRepository: WeatherRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        weatherRepository = WeatherRepositoryImpl(openWeatherApi)
    }

    @Test
    fun shouldReturnEmptyCityNameIfGetCurrentWeatherWithEmptyName() {
        whenever(weatherRepository.getCurrentWeather("")).thenReturn(
            Observable.just(CurrentWeather())
        )
        weatherRepository.getCurrentWeather("").subscribe {
            Assertions.assertEquals("", it.cityName)
        }
    }

    @Test
    fun shouldReturnCityNameIfGetCurrentWeatherWithName() {
        whenever(weatherRepository.getCurrentWeather("City")).thenReturn(
            Observable.just(CurrentWeather(cityName = "City"))
        )
        weatherRepository.getCurrentWeather("City").subscribe {
            Assertions.assertEquals("City", it.cityName)
        }
    }
}
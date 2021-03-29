package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.currentweatherPOJO.CurrentWeather
import org.junit.jupiter.api.BeforeEach

class CurrentWeatherTest {

    private lateinit var currentWeather: CurrentWeather

    @BeforeEach
    fun setUp() {
        currentWeather = CurrentWeather()
    }
}
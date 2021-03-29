package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.currentweatherPOJO.Weather
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class WeatherTest {

    private lateinit var weather: Weather

    @BeforeEach
    fun setUp() {
        weather = Weather()
    }

    @Test
    fun shouldHaveDefaultIdOf0() {
        assertEquals(0, weather.id)
    }

    @Test
    fun shouldHaveDefaultConditionEmpty() {
        assertTrue(weather.condition.isEmpty())
    }

    @Test
    fun shouldHaveDefaultDescriptionEmpty() {
        assertTrue(weather.description.isEmpty())
    }

    @Test
    fun shouldHaveDefaultIconEmpty() {
        assertTrue(weather.icon.isEmpty())
    }

    @Test
    fun shouldBeAbleToId() {
        weather.id = 100
        assertEquals(100, weather.id)
    }

    @Test
    fun shouldBeAbleToSetCondition() {
        weather.condition = "Clear"
        assertEquals("Clear", weather.condition)
    }

    @Test
    fun shouldBeAbleToSetDescription() {
        weather.description = "Clear sky"
        assertEquals("Clear sky", weather.description)
    }

    @Test
    fun shouldBeAbleToSetIcon() {
        weather.icon = "10n"
        assertEquals("10n", weather.icon)
    }
}
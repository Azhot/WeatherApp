package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.currentweatherPOJO.AtmosphericData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AtmosphericDataTest {

    private lateinit var atmosphericData: AtmosphericData

    @BeforeEach
    fun setUp() {
        atmosphericData = AtmosphericData()
    }

    @Test
    fun shouldHaveDefaultTemperatureOf0() =
        assertEquals(0.0, atmosphericData.temperature)

    @Test
    fun shouldHaveDefaultFeelsLikeOf0() =
        assertEquals(0.0, atmosphericData.feelsLike)

    @Test
    fun shouldHaveDefaultMinTemperatureOf0() =
        assertEquals(0.0, atmosphericData.minTemperature)

    @Test
    fun shouldHaveDefaultMaxTemperatureOf0() =
        assertEquals(0.0, atmosphericData.maxTemperature)

    @Test
    fun shouldHaveDefaultPressureOf0() =
        assertEquals(0, atmosphericData.pressure)

    @Test
    fun shouldHaveDefaultHumidityOf0() =
        assertEquals(0, atmosphericData.humidity)

    @Test
    fun shouldBeAbleToSetTemperature() {
        atmosphericData.temperature = 100.0
        assertEquals(100.0, atmosphericData.temperature)
    }

    @Test
    fun shouldBeAbleToSetFeelsLike() {
        atmosphericData.feelsLike = 110.0
        assertEquals(110.0, atmosphericData.feelsLike)
    }

    @Test
    fun shouldBeAbleToSetMinTemperature() {
        atmosphericData.minTemperature = 120.0
        assertEquals(120.0, atmosphericData.minTemperature)
    }

    @Test
    fun shouldBeAbleToSetMaxTemperature() {
        atmosphericData.maxTemperature = 130.0
        assertEquals(130.0, atmosphericData.maxTemperature)
    }

    @Test
    fun shouldBeAbleToSetPressure() {
        atmosphericData.pressure = 1013
        assertEquals(1013, atmosphericData.pressure)
    }

    @Test
    fun shouldBeAbleToSetHumidity() {
        atmosphericData.humidity = 70
        assertEquals(70, atmosphericData.humidity)
    }
}
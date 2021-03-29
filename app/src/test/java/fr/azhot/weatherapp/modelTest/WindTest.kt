package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.currentweatherPOJO.Wind
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class WindTest {

    private lateinit var wind: Wind

    @BeforeEach
    fun setUp() {
        wind = Wind()
    }

    @Test
    fun shouldHaveDefaultSpeedOf0() {
        assertEquals(0.0, wind.speed)
    }

    @Test
    fun shouldHaveDefaultDirectionOf0() {
        assertEquals(0, wind.direction)
    }

    @Test
    fun shouldBeAbleToSetSpeed() {
        wind.speed = 99.99
        assertEquals(99.99, wind.speed)
    }

    @Test
    fun shouldBeAbleToSetDirection() {
        wind.direction = 180
        assertEquals(180, wind.direction)
    }
}
package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.Location
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

class LocationTest {

    private lateinit var location: Location

    @BeforeEach
    fun setUp() {
        location = Location()
    }

    @Test
    fun shouldHaveDefaultCountryEmpty() {
        assertEquals("", location.country)
    }

    @Test
    fun shouldHaveDefaultSunriseOf0() {
        assertEquals(0, location.sunrise)
    }

    @Test
    fun shouldHaveDefaultSunsetOf0() {
        assertEquals(0, location.sunset)
    }

    @Test
    fun shouldBeAbleToSetCountry() {
        location.country = "FR"
        assertEquals("FR", location.country)
    }

    @Test
    fun shouldBeAbleToSetSunrise() {
        location.sunrise = 1
        assertEquals(1, location.sunrise)
    }

    @Test
    fun shouldBeAbleToSetSunset() {
        location.sunset = 2
        assertEquals(2, location.sunset)
    }
}
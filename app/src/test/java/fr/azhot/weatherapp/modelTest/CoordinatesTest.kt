package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.Coordinates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class CoordinatesTest {

    private lateinit var coordinates: Coordinates

    @BeforeEach
    fun setUp() {
        coordinates = Coordinates()
    }

    @Test
    fun shouldHaveDefaultLatitudeOf0() {
        assertEquals(0.0, coordinates.latitude)
    }

    @Test
    fun shouldHaveDefaultLongitudeOf0() {
        assertEquals(0.0, coordinates.longitude)
    }

    @Test
    fun shouldBeAbleToSetLatitude() {
        coordinates.latitude = 99.99
        assertEquals(99.99, coordinates.latitude)
    }

    @Test
    fun shouldBeAbleToSetLongitude() {
        coordinates.longitude = 88.88
        assertEquals(88.88, coordinates.longitude)
    }
}
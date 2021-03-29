package fr.azhot.weatherapp.modelTest

import fr.azhot.weatherapp.model.currentweatherPOJO.Clouds
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CloudsTest {

    private lateinit var clouds: Clouds

    @BeforeEach
    fun setUp() {
        clouds = Clouds()
    }

    @Test
    fun shouldHaveDefaultCloudinessOf0() {
        assertEquals(0, clouds.cloudiness)
    }

    @Test
    fun shouldBeAbleToSetCloudiness() {
        val clouds = Clouds()
        clouds.cloudiness = 99
        assertEquals(99, clouds.cloudiness)
    }
}
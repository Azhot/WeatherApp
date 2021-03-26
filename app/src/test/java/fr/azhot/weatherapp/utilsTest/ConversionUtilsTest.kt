package fr.azhot.weatherapp.utilsTest

import fr.azhot.weatherapp.utils.kelvinToCelsius
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ConversionUtilsTest {

    @ParameterizedTest
    @CsvSource(
        "273.15, 0.0",
        "283.15, 10.0",
        "293.00, 19.85"
    )
    fun kelvinToCelsius_itShouldReturnValidConversion(kelvin: Double, celsius: Double) {
        assertEquals(celsius, kelvinToCelsius(kelvin), 0.001)
    }
}
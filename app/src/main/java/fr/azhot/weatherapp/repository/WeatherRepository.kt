package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.model.CurrentWeather
import io.reactivex.Observable

interface WeatherRepository {
    fun getCurrentWeather(city: String): Observable<CurrentWeather>
}


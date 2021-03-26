package fr.azhot.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.azhot.weatherapp.api.OpenWeatherApi
import fr.azhot.weatherapp.service.RetrofitService

@Module
@InstallIn(SingletonComponent::class)
object OpenWeatherApiModule {

    @Provides
    fun provideOpenWeatherApi(): OpenWeatherApi =
        RetrofitService.createService(OpenWeatherApi::class.java)
}
package fr.azhot.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.azhot.weatherapp.network.OpenWeatherService
import fr.azhot.weatherapp.network.model.ForecastDtoMapper
import fr.azhot.weatherapp.repository.WeatherRepository
import fr.azhot.weatherapp.repository.WeatherRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        openWeatherService: OpenWeatherService,
        weatherDataDtoMapper: ForecastDtoMapper,
    ): WeatherRepository = WeatherRepositoryImpl(openWeatherService, weatherDataDtoMapper)
}
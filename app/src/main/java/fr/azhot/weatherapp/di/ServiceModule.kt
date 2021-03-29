package fr.azhot.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.azhot.weatherapp.api.HereAutocompleteApi
import fr.azhot.weatherapp.api.OpenWeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    private const val OPEN_WEATHER_BASE_URL = "https://api.openweathermap.org/"
    private const val AUTOCOMPLETE_BASE_URL = "https://autocomplete.search.hereapi.com/"

    @Provides
    fun provideOpenWeatherService() =
        Retrofit.Builder()
            .baseUrl(OPEN_WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherApi::class.java)

    @Provides
    fun provideHereAutocompleteService() =
        Retrofit.Builder()
            .baseUrl(AUTOCOMPLETE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HereAutocompleteApi::class.java)
}
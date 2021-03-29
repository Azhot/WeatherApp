package fr.azhot.weatherapp.di

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.azhot.weatherapp.model.autocompletePOJO.Autocomplete
import fr.azhot.weatherapp.model.currentweatherPOJO.CurrentWeather

@Module
@InstallIn(SingletonComponent::class)
object MutableLiveDataModule {

    @Provides
    fun provideCurrentWeatherMutableLiveData(): MutableLiveData<CurrentWeather> =
        MutableLiveData<CurrentWeather>()

    @Provides
    fun provideAutocompleteMutableLiveData(): MutableLiveData<Autocomplete> =
        MutableLiveData<Autocomplete>()
}
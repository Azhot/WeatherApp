package fr.azhot.weatherapp.di

import android.location.Address
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.azhot.weatherapp.model.City

@Module
@InstallIn(SingletonComponent::class)
object MutableLiveDataModule {

    @Provides
    fun provideWeatherDataMutableLiveData(): MutableLiveData<City> =
            MutableLiveData<City>()

    @Provides
    fun provideListAddressMutableLiveData(): MutableLiveData<List<Address>> =
            MutableLiveData<List<Address>>()
}
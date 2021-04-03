package fr.azhot.weatherapp.di

import android.location.Address
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import fr.azhot.weatherapp.domain.model.City

@Module
@InstallIn(ActivityRetainedComponent::class)
object MutableLiveDataModule {

    @ActivityRetainedScoped
    @Provides
    fun provideWeatherDataMutableLiveData(): MutableLiveData<City> = MutableLiveData<City>()

    @ActivityRetainedScoped
    @Provides
    fun provideListAddressMutableLiveData(): MutableLiveData<List<Address>> =
        MutableLiveData<List<Address>>()
}
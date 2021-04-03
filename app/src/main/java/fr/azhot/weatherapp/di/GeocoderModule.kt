package fr.azhot.weatherapp.di

import android.content.Context
import android.location.Geocoder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GeocoderModule {

    @Singleton
    @Provides
    fun provideGeocoder(@ApplicationContext context: Context) = Geocoder(context)
}
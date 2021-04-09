package fr.azhot.weatherapp.presentation.ui

import fr.azhot.weatherapp.util.DataState

interface DataStateListener {
    fun onDataStateChange(dataState: DataState<*>?)
}
package fr.azhot.weatherapp.repository

import fr.azhot.weatherapp.model.autocompletePOJO.Autocomplete
import kotlinx.coroutines.flow.Flow

interface AutocompleteRepository {
    fun fetchAutocomplete(cityName: String): Flow<Autocomplete>
}
package fr.azhot.weatherapp.repository

import android.util.Log
import fr.azhot.weatherapp.api.HereAutocompleteApi
import fr.azhot.weatherapp.model.autocompletePOJO.Autocomplete
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AutocompleteRepositoryImpl @Inject constructor(
    private val hereAutocompleteApi: HereAutocompleteApi
) : AutocompleteRepository {

    override fun fetchAutocomplete(cityName: String): Flow<Autocomplete> = flow {
        try {
            emit(hereAutocompleteApi.fetchAutocomplete(cityName))
        } catch (throwable: Throwable) {
            Log.e(this::class.java.simpleName, "fetchAutocomplete: ", throwable)
        }
    }
}
package fr.azhot.weatherapp.api

import fr.azhot.weatherapp.BuildConfig
import fr.azhot.weatherapp.model.autocompletePOJO.Autocomplete
import retrofit2.http.GET
import retrofit2.http.Query

interface HereAutocompleteApi {

    /**
     * A Retrofit GET request to the Here - Autocomplete - API.
     */
    @GET("v1/autocomplete?apiKey=" + BuildConfig.HERE_API_KEY)
    suspend fun fetchAutocomplete(
            @Query("q") cityName: String,
            @Query("limit") limit: Int = 1,
            @Query("type") type: String = "city",
    ): Autocomplete
}
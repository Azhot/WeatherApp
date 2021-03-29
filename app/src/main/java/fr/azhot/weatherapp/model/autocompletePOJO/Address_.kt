package fr.azhot.weatherapp.model.autocompletePOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Address_ {
    @SerializedName("label")
    @Expose
    var label: List<Label>? = null

    @SerializedName("city")
    @Expose
    var city: List<City>? = null
}

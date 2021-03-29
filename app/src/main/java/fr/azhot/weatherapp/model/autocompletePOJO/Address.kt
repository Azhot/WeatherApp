package fr.azhot.weatherapp.model.autocompletePOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {
    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("countryCode")
    @Expose
    var countryCode: String? = null

    @SerializedName("countryName")
    @Expose
    var countryName: String? = null

    @SerializedName("stateCode")
    @Expose
    var stateCode: String? = null

    @SerializedName("state")
    @Expose
    var state: String? = null

    @SerializedName("county")
    @Expose
    var county: String? = null

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("postalCode")
    @Expose
    var postalCode: String? = null
}

package fr.azhot.weatherapp.model.autocompletePOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Highlights {
    @SerializedName("title")
    @Expose
    var title: List<Title>? = null

    @SerializedName("address")
    @Expose
    var address: Address_? = null
}

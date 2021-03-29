package fr.azhot.weatherapp.model.autocompletePOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Item {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("resultType")
    @Expose
    var resultType: String? = null

    @SerializedName("localityType")
    @Expose
    var localityType: String? = null

    @SerializedName("address")
    @Expose
    var address: Address? = null

    @SerializedName("highlights")
    @Expose
    var highlights: Highlights? = null
}

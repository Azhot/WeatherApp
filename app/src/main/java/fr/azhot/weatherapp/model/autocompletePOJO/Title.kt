package fr.azhot.weatherapp.model.autocompletePOJO

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Title {
    @SerializedName("start")
    @Expose
    var start: Int? = null

    @SerializedName("end")
    @Expose
    var end: Int? = null
}

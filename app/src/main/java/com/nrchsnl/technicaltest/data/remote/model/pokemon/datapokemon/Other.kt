package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class Other (

    @SerializedName("dream_world")
    @Expose
    var dreamWorld: ImageData?,

    @SerializedName("home")
    @Expose
    var home: ImageData?,

    @SerializedName("official-artwork")
    @Expose
    var officialArtwork: ImageData?
)
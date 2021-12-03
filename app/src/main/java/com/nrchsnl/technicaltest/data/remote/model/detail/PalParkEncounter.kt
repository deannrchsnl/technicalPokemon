package com.nrchsnl.technicaltest.data.remote.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon

data class PalParkEncounter (
    @SerializedName("area")
    @Expose
    var area: ListPokemon? = null,

    @SerializedName("base_score")
    @Expose
    var baseScore: Int? = null,

    @SerializedName("rate")
    @Expose
    var rate: Int? = null
)
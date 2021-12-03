package com.nrchsnl.technicaltest.data.remote.model.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon

data class Variety (

    @SerializedName("is_default")
    @Expose
    var isDefault: Boolean? = null,

    @SerializedName("pokemon")
    @Expose
    var pokemon: ListPokemon? = null
)
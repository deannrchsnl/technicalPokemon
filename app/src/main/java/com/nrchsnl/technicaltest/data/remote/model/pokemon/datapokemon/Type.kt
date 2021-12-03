package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class Type (
    @SerializedName("slot")
    @Expose
    var slot: Int?,

    @SerializedName("type")
    @Expose
    var type: ListPokemon?
)
package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class Stat (

    @SerializedName("base_stat")
    @Expose
    var baseStat: Int?,

    @SerializedName("effort")
    @Expose
    var effort: Int?,

    @SerializedName("stat")
    @Expose
    var stat: ListPokemon?
)
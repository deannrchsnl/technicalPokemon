package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class Ability (
    @SerializedName("ability")
    @Expose
    var ability: ListPokemon?,

    @SerializedName("is_hidden")
    @Expose
    var isHidden: Boolean?,

    @SerializedName("slot")
    @Expose
    var slot: Int?

)
package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class GameIndex (
    @SerializedName("game_index")
    @Expose
    var gameIndex: Int?,

    @SerializedName("version")
    @Expose
    var version: ListPokemon?

)
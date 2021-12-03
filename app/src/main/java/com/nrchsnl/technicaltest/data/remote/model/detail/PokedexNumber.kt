package com.nrchsnl.technicaltest.data.remote.model.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class PokedexNumber (

    @SerializedName("entry_number")
    @Expose
    var entryNumber: Int? = null,

    @SerializedName("pokedex")
    @Expose
    var pokedex: ListPokemon? = null
)
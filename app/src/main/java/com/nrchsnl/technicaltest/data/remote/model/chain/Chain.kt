package com.nrchsnl.technicaltest.data.remote.model.chain

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


class Chain {

    @SerializedName("evolution_details")
    @Expose
    var evolutionDetails: List<EvolutionDetails>? = null

    @SerializedName("evolves_to")
    @Expose
    var evolvesTo: List<EvolveTo>? = null

    @SerializedName("is_baby")
    @Expose
    var isBaby: Boolean? = null

    @SerializedName("species")
    @Expose
    var species: ListPokemon? = null
}
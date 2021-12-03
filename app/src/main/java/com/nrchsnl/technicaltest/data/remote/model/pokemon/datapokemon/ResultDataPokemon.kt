package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class ResultDataPokemon (
    var isLast : Boolean = false,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    var index: Int? = null,

    @SerializedName("abilities")
    @Expose
    var abilities: List<Ability>? = null,

    @SerializedName("base_experience")
    @Expose
    var baseExperience: Int? = null,

    @SerializedName("forms")
    @Expose
    var forms: List<ListPokemon>? = null,

    @SerializedName("game_indices")
    @Expose
    var gameIndices: List<GameIndex>? = null,

    @SerializedName("height")
    @Expose
    var height: Int? = null,

    @SerializedName("held_items")
    @Expose
    var heldItems: List<Any>? = null,

    @SerializedName("is_default")
    @Expose
    var isDefault: Boolean? = null,

    @SerializedName("location_area_encounters")
    @Expose
    var locationAreaEncounters: String? = null,

    @SerializedName("moves")
    @Expose
    var moves: List<Move>? = null,

    @SerializedName("order")
    @Expose
    var order: Int? = null,

    @SerializedName("past_types")
    @Expose
    var pastTypes: List<Any>? = null,

    @SerializedName("species")
    @Expose
    var species: ListPokemon? = null,

    @SerializedName("sprites")
    @Expose
    var sprites: Sprites? = null,

    @SerializedName("stats")
    @Expose
    var stats: List<Stat>? = null,

    @SerializedName("types")
    @Expose
    var types: List<Type>? = null,

    @SerializedName("weight")
    @Expose
    var weight: Int? = null

)
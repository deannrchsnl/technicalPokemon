package com.nrchsnl.technicaltest.data.remote.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon
import org.intellij.lang.annotations.Language

data class FlavorTextEntry (

    @SerializedName("flavor_text")
    @Expose
    var flavorText: String? = null,

    @SerializedName("language")
    @Expose
    var language: ListPokemon? = null,

    @SerializedName("version")
    @Expose
    var version: ListPokemon? = null,

    @SerializedName("genus")
    @Expose
    var genus: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)
package com.nrchsnl.technicaltest.data.remote.model.pokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ListPokemon (
    @SerializedName("name")
    @Expose
    var name: String?,

    @SerializedName("url")
    @Expose
    var url: String?

)
package com.nrchsnl.technicaltest.data.remote.model.pokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ResultListPokemon(
    @SerializedName("count")
    @Expose
    var count: Int?,

    @SerializedName("next")
    @Expose
    var next: String?,

    @SerializedName("previous")
    @Expose
    var previous: String?,

    @SerializedName("results")
    @Expose
    var listPokemon : List<ListPokemon>?

)

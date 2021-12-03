package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Versions (

    @SerializedName("generation-i")
    @Expose
    var generationI: Generation?,

    @SerializedName("generation-ii")
    @Expose
    var generationIi: Generation?,

    @SerializedName("generation-iii")
    @Expose
    var generationIii: Generation?,

    @SerializedName("generation-iv")
    @Expose
    var generationIv: Generation?,

    @SerializedName("generation-v")
    @Expose
    var generationV: Generation?,

    @SerializedName("generation-vi")
    @Expose
    var generationVi: Generation?,

    @SerializedName("generation-vii")
    @Expose
    var generationVii: Generation?,

    @SerializedName("generation-viii")
    @Expose
    var generationViii: Generation?
)
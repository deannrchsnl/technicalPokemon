package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class Move (
    @SerializedName("move")
    @Expose
    var move: ListPokemon?,

    @SerializedName("version_group_details")
    @Expose
    var versionGroupDetails: List<VersionGroupDetail>?

)
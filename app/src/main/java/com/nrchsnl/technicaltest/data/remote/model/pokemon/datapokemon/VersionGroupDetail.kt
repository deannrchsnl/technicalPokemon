package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


data class VersionGroupDetail (
    @SerializedName("level_learned_at")
    @Expose
    var levelLearnedAt: Int?,

    @SerializedName("move_learn_method")
    @Expose
    var moveLearnMethod: ListPokemon?,

    @SerializedName("version_group")
    @Expose
    var versionGroup: ListPokemon?

)
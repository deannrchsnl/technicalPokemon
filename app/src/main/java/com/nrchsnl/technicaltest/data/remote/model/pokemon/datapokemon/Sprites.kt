package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Sprites (
    @SerializedName("back_default")
    @Expose
    var backDefault: String?,

    @SerializedName("back_female")
    @Expose
    var backFemale: Any?,

    @SerializedName("back_shiny")
    @Expose
    var backShiny: String?,

    @SerializedName("back_shiny_female")
    @Expose
    var backShinyFemale: Any?,

    @SerializedName("front_default")
    @Expose
    var frontDefault: String?,

    @SerializedName("front_female")
    @Expose
    var frontFemale: Any?,

    @SerializedName("front_shiny")
    @Expose
    var frontShiny: String?,

    @SerializedName("front_shiny_female")
    @Expose
    var frontShinyFemale: Any?,

    @SerializedName("other")
    @Expose
    var other: Other?,

    @SerializedName("versions")
    @Expose
    var versions: Versions?
)
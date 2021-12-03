package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ImageData (
    @SerializedName("back_default")
    @Expose
    var backDefault: String?,

    @SerializedName("back_female")
    @Expose
    var backFemale: String?,

    @SerializedName("back_shiny")
    @Expose
    var backShiny: String?,

    @SerializedName("back_shiny_female")
    @Expose
    var backShinyFemale: String?,

    @SerializedName("front_default")
    @Expose
    var frontDefault: String?,

    @SerializedName("front_female")
    @Expose
    var frontFemale: String?,

    @SerializedName("front_shiny")
    @Expose
    var frontShiny: String?,

    @SerializedName("front_shiny_female")
    @Expose
    var frontShinyFemale: String?,

    @SerializedName("back_gray")
    @Expose
    var backGray: Any?,

    @SerializedName("back_transparent")
    @Expose
    var backTransparent: Any?,

    @SerializedName("front_gray")
    @Expose
    var frontGray: Any?,

    @SerializedName("front_transparent")
    @Expose
    var frontTransparent: Any?,

    @SerializedName("front_shiny_transparent")
    @Expose
    var frontShinyTransparent: String?,

    @SerializedName("back_shiny_transparent")
    @Expose
    var backShinyTransparent: String?,

    @SerializedName("animated")
    @Expose
    var animated: ImageData?

)
package com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Generation (
    @SerializedName("red-blue")
    @Expose
    var redBlue: ImageData?,

    @SerializedName("yellow")
    @Expose
    var yellow: ImageData?,

    @SerializedName("crystal")
    @Expose
    var crystal: ImageData?,

    @SerializedName("gold")
    @Expose
    var gold: ImageData?,

    @SerializedName("emerald")
    @Expose
    var emerald: ImageData?,

    @SerializedName("firered-leafgreen")
    @Expose
    var fireredLeafgreen: ImageData?,

    @SerializedName("ruby-sapphire")
    @Expose
    var rubySapphire: ImageData?,

    @SerializedName("diamond-pearl")
    @Expose
    var diamondPearl: ImageData?,

    @SerializedName("heartgold-soulsilver")
    @Expose
    var heartgoldSoulsilver: ImageData?,

    @SerializedName("platinum")
    @Expose
    var platinum: ImageData?,

    @SerializedName("silver")
    @Expose
    var silver: ImageData?,

    @SerializedName("black-white")
    @Expose
    var blackWhite: ImageData?,

    @SerializedName("omegaruby-alphasapphire")
    @Expose
    var omegarubyAlphasapphire: ImageData?,

    @SerializedName("x-y")
    @Expose
    var xY: ImageData?,

    @SerializedName("icons")
    @Expose
    var icons: ImageData?,

    @SerializedName("ultra-sun-ultra-moon")
    @Expose
    var ultraSunUltraMoon: ImageData?
)
{
}
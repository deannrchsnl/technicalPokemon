package com.nrchsnl.technicaltest.ui.main

import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon

interface MainListener {
    fun itemOnClick(data : ResultDataPokemon)
}
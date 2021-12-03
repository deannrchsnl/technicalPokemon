package com.nrchsnl.technicaltest.data.remote

import com.nrchsnl.technicaltest.data.remote.model.chain.ResultEvolutionChain
import com.nrchsnl.technicaltest.data.remote.model.detail.ResultDataSpecies
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ResultListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon

class MainRemoteDataSource(private val service: MainService) {

    /**
     * Get List Pokemon
     */
    suspend fun getListPokemon(limit : Int, offset : Int): ResultListPokemon {
        return service.getListPokemon(limit, offset)
    }
    /**
     * Get List Pokemon
     */
    suspend fun getDetailPokemon(id : String): ResultDataPokemon {
        return service.getDetailPokemon(id)
    }
    suspend fun getDataSpecies(id : String): ResultDataSpecies {
        return service.getDetailSpecies(id)
    }
    suspend fun getDataEvolution(id : String): ResultEvolutionChain {
        return service.getEvolition(id)
    }
}
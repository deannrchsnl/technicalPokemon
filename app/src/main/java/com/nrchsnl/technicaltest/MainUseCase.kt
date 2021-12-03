package com.nrchsnl.technicaltest

import com.nrchsnl.technicaltest.data.remote.MainRemoteDataSource
import com.nrchsnl.technicaltest.data.remote.model.chain.ResultEvolutionChain
import com.nrchsnl.technicaltest.data.remote.model.detail.ResultDataSpecies
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ResultListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon

class MainUseCase(private val remoteRepository: MainRemoteDataSource?) {

    suspend fun getListPokemon(limit : Int, offset : Int): ResultListPokemon{
        return remoteRepository!!.getListPokemon(limit, offset)
    }
    suspend fun getDetailPokemon(id : String): ResultDataPokemon{
        return remoteRepository!!.getDetailPokemon(id)
    }
    suspend fun getDetailSpecies(id : String): ResultDataSpecies{
        return remoteRepository!!.getDataSpecies(id)
    }
    suspend fun getEvolution(id : String): ResultEvolutionChain{
        return remoteRepository!!.getDataEvolution(id)
    }
}
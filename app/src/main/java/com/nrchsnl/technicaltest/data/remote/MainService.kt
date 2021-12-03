package com.nrchsnl.technicaltest.data.remote

import com.nrchsnl.technicaltest.data.remote.model.chain.ResultEvolutionChain
import com.nrchsnl.technicaltest.data.remote.model.detail.ResultDataSpecies
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ResultListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by deannrchsnl on 25/10/21.
 */
interface MainService {

    //       POKEMON

    /**
     * Get list pokemon
     */

    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("limit") limit : Int,
        @Query("offset") offset : Int
    ): ResultListPokemon

    /**
     * Get data pokemon
     */

    @GET("pokemon/{id}")
    suspend fun getDetailPokemon(
        @Path("id") id: String
    ): ResultDataPokemon


    @GET("pokemon-species/{id}")
    suspend fun getDetailSpecies(
        @Path("id") id: String
    ): ResultDataSpecies

    @GET("evolution-chain//{id}")
    suspend fun getEvolition(
        @Path("id") id: String
    ): ResultEvolutionChain



}
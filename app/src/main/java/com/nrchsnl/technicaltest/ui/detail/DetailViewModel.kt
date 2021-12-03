package com.nrchsnl.technicaltest.ui.detail

import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nrchsnl.technicaltest.MainUseCase
import com.nrchsnl.technicaltest.base.BaseViewModel
import com.nrchsnl.technicaltest.data.remote.model.chain.ResultEvolutionChain
import com.nrchsnl.technicaltest.data.remote.model.detail.ResultDataSpecies
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.helper.SingleLiveEvent
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailViewModel @Inject constructor() : BaseViewModel() {

    var dataPokemon = ResultDataPokemon()
    var dataEvolutionChain = ResultEvolutionChain()
    val mDataSpecies = SingleLiveEvent<ResultDataSpecies>()
    val mDataEvolution = SingleLiveEvent<ResultEvolutionChain>()

    var evol1 = SingleLiveEvent<ResultDataPokemon>()
    var evol2 = SingleLiveEvent<ResultDataPokemon>()
    var evol3 = SingleLiveEvent<ResultDataPokemon>()
    @Inject
    lateinit var mUseCase: MainUseCase

    fun changeTypeData(data : String) : ResultDataPokemon{
        dataPokemon = Gson().fromJson(data, ResultDataPokemon::class.java)
        return dataPokemon
    }

    fun getDetailSpecies(){
        var list = dataPokemon.species?.url?.split("/")
        var id = list?.get((list.size-2))
        viewModelScope.launch {
            withContext(dispatcher) {
                val content = mUseCase.getDetailSpecies(id!!)
                mDataSpecies.value = content
            }
        }
    }

    fun getDetailEvolution(url : String){
        var list = url.split("/")
        var id = list?.get((list.size-2))
        viewModelScope.launch {
            withContext(dispatcher) {
                val content = mUseCase.getEvolution(id!!)
                dataEvolutionChain = content
                mDataEvolution.value = dataEvolutionChain
                checkEvol()
            }
        }
    }
    fun checkEvol(){
        if(dataEvolutionChain.chain?.species?.name == dataPokemon.name){
            evol1.value = dataPokemon
        }else{
            getDataPokemon(1, dataEvolutionChain.chain?.species?.name!!)
        }
        if(dataEvolutionChain.chain?.evolvesTo != null) {
            if (dataEvolutionChain.chain?.evolvesTo!![0].species?.name == dataPokemon.name) {
                evol2.value = dataPokemon
            } else {
                getDataPokemon(2, dataEvolutionChain.chain?.evolvesTo!![0].species?.name!!)
            }
        }
        if(dataEvolutionChain.chain?.evolvesTo != null && !dataEvolutionChain.chain?.evolvesTo!![0].evolvesTo.isNullOrEmpty() ) {
            if (dataEvolutionChain.chain?.evolvesTo!![0].evolvesTo!![0].species?.name == dataPokemon.name) {
                evol3.value = dataPokemon
            } else {
                getDataPokemon(3, dataEvolutionChain.chain?.evolvesTo!![0].evolvesTo!![0].species?.name!!)
            }
        }
    }
    fun getDataPokemon(evol : Int, name : String){
        viewModelScope.launch {
            withContext(dispatcher) {
                val content = mUseCase.getDetailPokemon(name)
                when (evol) {
                    1 -> {
                        evol1.value = content
                    }
                    2 -> {
                        evol2.value = content
                    }
                    3 -> {
                        evol3.value = content
                    }
                }
            }
        }
    }
}
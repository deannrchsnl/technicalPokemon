package com.nrchsnl.technicaltest.ui.main

import androidx.lifecycle.viewModelScope
import com.nrchsnl.technicaltest.MainUseCase
import com.nrchsnl.technicaltest.base.BaseViewModel
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.helper.SingleLiveEvent
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var mUseCase: MainUseCase

    val listPokemon = SingleLiveEvent<List<ResultDataPokemon>>()

    val listUpdatePokemon = SingleLiveEvent<List<ResultDataPokemon>>()

    val updateDetail = SingleLiveEvent<ResultDataPokemon>()


    var limit = 20
    var offset = 0
    fun getListPokemon() {
        viewModelScope.launch {
            withContext(dispatcher) {
                val content = mUseCase.getListPokemon(limit, offset)
                setListResulttoListData(content.listPokemon!!)
            }
        }
    }
    fun setListResulttoListData(list: List<ListPokemon>){
        val listDataPokemon = ArrayList<ResultDataPokemon>()
        for(data in list){
            var list = data.url?.split("/")
            var id = list?.get((list.size-2))
            listDataPokemon.add(ResultDataPokemon(false, id!!.toInt(), data.name))
        }
        listPokemon.value = listDataPokemon
    }

    fun getDetailPokemon(index : Int, id : Int){
        viewModelScope.launch {
            withContext(dispatcher) {
                val content = mUseCase.getDetailPokemon(id.toString())
                content.index = index
                updateDetail.value = content
            }
        }
    }

    fun getUpdateListPokemon(){
        offset += 20
        viewModelScope.launch {
            withContext(dispatcher) {
                val content = mUseCase.getListPokemon(limit, offset)
                setUpdateListResulttoListData(content.listPokemon!!)
            }
        }
    }
    fun setUpdateListResulttoListData(list: List<ListPokemon>){
        val listDataPokemon = ArrayList<ResultDataPokemon>()
        for(data in list){
            var list = data.url?.split("/")
            var id = list?.get((list.size-2))
            listDataPokemon.add(ResultDataPokemon(false, id!!.toInt(), data.name))
        }
        listUpdatePokemon.value = listDataPokemon
    }
}
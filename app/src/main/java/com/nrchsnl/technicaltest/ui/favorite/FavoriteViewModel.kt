package com.nrchsnl.technicaltest.ui.favorite

import androidx.lifecycle.viewModelScope
import com.nrchsnl.technicaltest.MainUseCase
import com.nrchsnl.technicaltest.base.BaseViewModel
import com.nrchsnl.technicaltest.data.local.PreferenceHelper
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.helper.SingleLiveEvent
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoriteViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var mUseCase: MainUseCase


    val listPokemon = SingleLiveEvent<List<ResultDataPokemon>>()

    val updateDetail = SingleLiveEvent<ResultDataPokemon>()

    fun getListPokemon() {
        val content = PreferenceHelper.getListData()
        setListResulttoListData(content)
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
}
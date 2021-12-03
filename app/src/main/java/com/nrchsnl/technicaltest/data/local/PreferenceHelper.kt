package com.nrchsnl.technicaltest.data.local

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nrchsnl.technicaltest.TechnicaltestApp
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon


object PreferenceHelper {
    private val PREF_FAV = "PREF_FAV"

    private fun getSharedPreference(): SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(TechnicaltestApp.appContext)
    }

    public fun setData(data : ArrayList<ListPokemon>) {
        getSharedPreference().edit().putString(PREF_FAV, Gson().toJson(data)).commit()
    }
    
    public fun addData(data : ListPokemon){
        var datas = getListData()
        if(datas != null) {
            datas.add(data)
            setData(datas)
        }
    }
    public fun removeData(data : ListPokemon){
        var datas = getListData()
        if(!datas.isNullOrEmpty()) {
            datas.remove(data)
            setData(datas)
        }
    }

    public fun getListData(): ArrayList<ListPokemon> {
        var data = ArrayList<ListPokemon>()
        var datas = getSharedPreference().getString(PREF_FAV, "[]")
        val outputList: List<ListPokemon> = Gson().fromJson(datas, object : TypeToken<ArrayList<ListPokemon?>?>() {}.type)
        if(!outputList.isNullOrEmpty()) {
            data.addAll(outputList)
        }

        return data
    }

    public fun getData(data : String) : Boolean{
        var datas = getListData()
        if(!datas.isNullOrEmpty()) {
            for (i in datas) {
                if (data == i.name) {
                    return true
                }
            }
        }
        return false
    }

}
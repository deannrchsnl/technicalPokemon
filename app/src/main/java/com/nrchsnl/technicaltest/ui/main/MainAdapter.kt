package com.nrchsnl.technicaltest.ui.main

import android.view.View
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseAdapter
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.helper.extensions.setImageGif
import com.nrchsnl.technicaltest.helper.extensions.setImageUrl
import com.nrchsnl.technicaltest.helper.extensions.setImagebyType
import kotlinx.android.synthetic.main.item_list_pokemon.view.*

class MainAdapter(private val mListener: MainListener) : BaseAdapter<ResultDataPokemon>() {
    override val layout: Int = R.layout.item_list_pokemon

    override fun bind(data: ResultDataPokemon, itemView: View, position: Int) {
        itemView.apply {
            tvTitle.setText(data.name)
            data.sprites?.other?.officialArtwork?.frontDefault?.let { ivChar.setImageUrl(it) }

            if(data.types != null){
                types1.setImagebyType(data.types!![0].type?.name!!)
                if(data.types!!.size == 2){
                    types2.setImagebyType(data.types!![1].type?.name!!)
                }

                if (data.types!!.size == 3){
                    types3.setImagebyType(data.types!![2].type?.name!!)
                }
            }
            if(data.isLast){
                content.visibility = View.GONE
                progress.visibility = View.VISIBLE
                progress.setImageGif(R.drawable.loading)
            }
            this.setOnClickListener { mListener.itemOnClick(data) }
        }
    }
}
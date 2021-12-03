package com.nrchsnl.technicaltest.ui.detail

import android.view.View
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseAdapter
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.Stat
import kotlinx.android.synthetic.main.item_stats.view.*

class StatsAdapter() : BaseAdapter<Stat>() {
    override val layout: Int = R.layout.item_stats
    override fun bind(data: Stat, itemView: View, position: Int) {
        itemView.run {
            tvName.text = data.stat?.name
            tvPoin.text = data.baseStat.toString()
            pgStat.progress = data.baseStat!!
        }
    }
}
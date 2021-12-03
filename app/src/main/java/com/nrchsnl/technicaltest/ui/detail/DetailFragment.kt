package com.nrchsnl.technicaltest.ui.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nrchsnl.technicaltest.MainEnvironment
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseFragment
import com.nrchsnl.technicaltest.data.local.PreferenceHelper
import com.nrchsnl.technicaltest.data.remote.model.chain.ResultEvolutionChain
import com.nrchsnl.technicaltest.data.remote.model.detail.ResultDataSpecies
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.di.DaggerMainComponent
import com.nrchsnl.technicaltest.di.MainDataModule
import com.nrchsnl.technicaltest.helper.extensions.changeBackgroundByType
import com.nrchsnl.technicaltest.helper.extensions.setImageUrl
import com.nrchsnl.technicaltest.helper.extensions.setImagebyType
import com.nrchsnl.technicaltest.helper.extensions.setupLinearLayoutManager
import com.nrchsnl.technicaltest.ui.main.MainAdapter
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.title
import kotlinx.android.synthetic.main.fragment_evolution.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_list_pokemon.view.*
import javax.inject.Inject

class DetailFragment: BaseFragment<DetailViewModel>(), DetailListener {

    var dataPokemon = ResultDataPokemon()
    var dataSpecies = ResultDataSpecies()
    var dataEvolution = ResultEvolutionChain()

    var isFavorite = false

    companion object {
        fun newInstance(bundle: Bundle): DetailFragment {
            return DetailFragment().apply {
                arguments = bundle
            }
        }
    }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel: DetailViewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)[DetailViewModel::class.java]
    }

    override fun getLayoutRes(): Int = R.layout.fragment_detail

    override fun onCreateInjector() {
        DaggerMainComponent.builder()
            .mainDataModule(MainDataModule(requireContext()))
            .build()
            .inject(this)
    }

    override fun onCreateViewModel(): DetailViewModel = mViewModel
    override fun onCreateObserver(viewModel: DetailViewModel) {
        viewModel.run {
            mDataSpecies.observe(this@DetailFragment, Observer {
                dataSpecies = it
                setDataSpecies()
                mViewModel.getDetailEvolution(it.evolutionChain?.url!!)
            })

            mDataEvolution.observe(this@DetailFragment, Observer {
                dataEvolution = it
                setDataEvolution()
            })

            evol1.observe(this@DetailFragment, Observer {
                it.sprites?.other?.officialArtwork?.frontDefault?.let { ivEvol1.setImageUrl(it) }
            })
            evol2.observe(this@DetailFragment, Observer {
                it.sprites?.other?.officialArtwork?.frontDefault?.let { ivEvol2.setImageUrl(it) }
                tvLv1.setText("level " + (dataEvolution.chain?.evolvesTo!![0].evolutionDetails!![0].minLevel))
            })
            evol3.observe(this@DetailFragment, Observer {
                it.sprites?.other?.officialArtwork?.frontDefault?.let { ivEvol3.setImageUrl(it) }
                tvLv2.setText("level " + (dataEvolution.chain?.evolvesTo!![0].evolvesTo!![0].evolutionDetails!![0].minLevel))
            })
        }
    }

    private fun setDataEvolution() {
        if(dataEvolution.chain?.evolvesTo!![0].evolvesTo.isNullOrEmpty()){
            lyLv2.visibility = View.GONE
            ivEvol3.visibility = View.GONE
        }
    }

    private fun setDataSpecies() {
        tvAbout.setText(dataSpecies.flavorTextEntries?.get(6)?.flavorText)
        tvSpecies.setText(dataPokemon.species?.name)
        tvHeight.setText(dataPokemon.height.toString())
        tvWeight.setText(dataPokemon.weight.toString())
        var ability = ""
        for(data in dataPokemon.abilities!!){
            if(ability != ""){
                ability += ", "
            }
            ability += data.ability?.name
        }
        tvAbility.setText(ability)
        var eggGroup = ""
        for(data in dataSpecies.eggGroups!!){
            if(eggGroup != ""){
                eggGroup += ", "
            }
            eggGroup += data.name
        }
        tvEggGroup.setText(eggGroup)
        var pokedex = ""
        for(data in dataSpecies.pokedexNumbers!!){
            if(pokedex != ""){
                pokedex += ", "
            }
            pokedex += data.pokedex?.name
        }
        tvPokedex.setText(pokedex)

        tvHabitat.setText(dataSpecies.habitat?.name)
    }

    override fun setContentData() {
        var data = (requireActivity() as DetailActivity).intent.getStringExtra("data")
        if (data != null) {
            dataPokemon = mViewModel.changeTypeData(data)
        }

        mViewModel.getDetailSpecies()
        title.setText(dataPokemon.name)
        var ids = "#"
        ids += when {
            dataPokemon.id!! < 10 -> {
                "000${dataPokemon.id}"
            }
            dataPokemon.id!! < 100 -> {
                "00${dataPokemon.id}"
            }
            dataPokemon.id!! < 1000 -> {
                "0${dataPokemon.id}"
            }
            else -> {
                "${dataPokemon.id}"
            }
        }
        tvId.setText(ids)

        if(dataPokemon.types != null){
            cvType2.visibility = View.GONE
            ivTypes1.setImagebyType(dataPokemon.types!![0].type?.name!!)
            cvType1.visibility = View.VISIBLE
            lvType1.changeBackgroundByType(dataPokemon.types!![0].type?.name!!)
            tvType1.setText(dataPokemon.types!![0].type?.name!!)
            if(dataPokemon.types!!.size == 2){
                ivTypes2.setImagebyType(dataPokemon.types!![1].type?.name!!)
                cvType2.visibility = View.VISIBLE
                lvType2.changeBackgroundByType(dataPokemon.types!![1].type?.name!!)
                tvType2.setText(dataPokemon.types!![1].type?.name!!)
            }
        }

        dataPokemon.sprites?.other?.officialArtwork?.frontDefault?.let { ivAvatar.setImageUrl(it) }
        ivAvatar.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data", Gson().toJson(dataPokemon))
            MainEnvironment.routeNavigation.openImagePage(requireContext(), bundle)
        }

        ivBack.setOnClickListener {
            (requireActivity() as DetailActivity).finish()
        }
        isFavorite = PreferenceHelper.getData(dataPokemon.name!!)

        if(isFavorite){
            ivFav.setImageResource(R.drawable.ic_favorite)
        }else{
            ivFav.setImageResource(R.drawable.ic_unfavorite)
        }

        ivFav.setOnClickListener {
            if(isFavorite){
                var id = dataPokemon.id
                var data = ListPokemon(dataPokemon.name!!, "https://pokeapi.co/api/v2/pokemon/$id/")
                PreferenceHelper.removeData(data)
                ivFav.setImageResource(R.drawable.ic_unfavorite)
                isFavorite = false
            }else{
                var id = dataPokemon.id
                var data = ListPokemon(dataPokemon.name!!, "https://pokeapi.co/api/v2/pokemon/$id/")
                PreferenceHelper.addData(data)
                ivFav.setImageResource(R.drawable.ic_favorite)
                isFavorite = true
            }
        }
        setupTab()
        setupStat()
    }

    private fun setupStat() {
        var statsAdapter = StatsAdapter()
        rvStats.apply {
            setHasFixedSize(true)
            setupLinearLayoutManager(RecyclerView.VERTICAL, false)
            adapter = statsAdapter
        }

        statsAdapter.setRecyclerData(dataPokemon.stats!!)
    }

    fun setupTab(){

        lyAbout.visibility = View.VISIBLE
        rvStats.visibility = View.GONE
        lyEvol.visibility = View.GONE

        lyIndicatorAbout.setOnClickListener {
            lyAbout.visibility = View.VISIBLE
            rvStats.visibility = View.GONE
            lyEvol.visibility = View.GONE

            viewIndicatorAbout.visibility = View.VISIBLE
            viewIndicatorStats.visibility = View.GONE
            viewIndicatorEvolution.visibility = View.GONE

            tvIndicatorAbout.setTextColor(resources.getColor(R.color.main))
            tvIndicatorStats.setTextColor(resources.getColor(R.color.lightgrey))
            tvIndicatorEvolution.setTextColor(resources.getColor(R.color.lightgrey))
        }
        lyIndicatorStats.setOnClickListener {
            lyAbout.visibility = View.GONE
            rvStats.visibility = View.VISIBLE
            lyEvol.visibility = View.GONE

            viewIndicatorAbout.visibility = View.GONE
            viewIndicatorStats.visibility = View.VISIBLE
            viewIndicatorEvolution.visibility = View.GONE

            tvIndicatorAbout.setTextColor(resources.getColor(R.color.lightgrey))
            tvIndicatorStats.setTextColor(resources.getColor(R.color.main))
            tvIndicatorEvolution.setTextColor(resources.getColor(R.color.lightgrey))
        }
        lyIndicatorEvolution.setOnClickListener {
            lyAbout.visibility = View.GONE
            rvStats.visibility = View.GONE
            lyEvol.visibility = View.VISIBLE

            viewIndicatorAbout.visibility = View.GONE
            viewIndicatorStats.visibility = View.GONE
            viewIndicatorEvolution.visibility = View.VISIBLE

            tvIndicatorAbout.setTextColor(resources.getColor(R.color.lightgrey))
            tvIndicatorStats.setTextColor(resources.getColor(R.color.lightgrey))
            tvIndicatorEvolution.setTextColor(resources.getColor(R.color.main))
        }
    }
}
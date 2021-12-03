package com.nrchsnl.technicaltest.ui.main

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nrchsnl.technicaltest.MainEnvironment.routeNavigation.openDetailPage
import com.nrchsnl.technicaltest.MainEnvironment.routeNavigation.openFavoritePage
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseFragment
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.ResultListPokemon
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.di.DaggerMainComponent
import com.nrchsnl.technicaltest.di.MainDataModule
import com.nrchsnl.technicaltest.helper.extensions.setupLinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class MainFragment: BaseFragment<MainViewModel>(), MainListener {

    private lateinit var mainAdapter: MainAdapter

    companion object {
        fun newInstance(bundle: Bundle): MainFragment {
            return MainFragment().apply {
                arguments = bundle
            }
        }
    }

    var offer = 0
    var listUpdate = true
    var isLoading = false
    var dataPokemon = ArrayList<ResultDataPokemon>()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel: MainViewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onCreateInjector() {
        DaggerMainComponent.builder()
            .mainDataModule(MainDataModule(requireContext()))
            .build()
            .inject(this)
    }

    override fun onCreateViewModel(): MainViewModel = mViewModel


    override fun setContentData() {
        mViewModel.getListPokemon()
        rvPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                Handler().postDelayed({
                    if(!isLoading && listUpdate){
                        if(linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == dataPokemon.lastIndex){
                            mViewModel.getUpdateListPokemon()
                            isLoading = true
                        }
                    }
                }, 3000)
            }
        })

        ivFavorite.setOnClickListener {
            openFavoritePage(requireContext())
        }
    }

    override fun onCreateObserver(viewModel: MainViewModel) {
        viewModel.run {
            listPokemon.observe(this@MainFragment, Observer {
                isLoading = false
                listUpdate = it.size > 19
                dataPokemon = it as ArrayList<ResultDataPokemon>
                setUpList()
            })
            updateDetail.observe(this@MainFragment, Observer {
                update(it)
            })

            listUpdatePokemon.observe(this@MainFragment, Observer {
                isLoading = false
                dataPokemon.removeAt(dataPokemon.lastIndex)
                dataPokemon.addAll(it)
                listUpdate = it.size > 19
                if(listUpdate) {
                    dataPokemon.add(ResultDataPokemon(true, 0, ""))
                }
                getDetailPokemon()
            })
        }
    }

    fun update(data: ResultDataPokemon){
        dataPokemon[data.index!!] = data
        mainAdapter.setRecyclerData(dataPokemon)
    }

    private fun setUpList() {
        getDetailPokemon()
        mainAdapter = MainAdapter(this)
        rvPokemon.apply {
            setHasFixedSize(true)
            setupLinearLayoutManager(RecyclerView.VERTICAL, false)
            adapter = mainAdapter
        }
        if(listUpdate) {
            dataPokemon.add(ResultDataPokemon(true, 0, ""))
        }
        mainAdapter.setRecyclerData(dataPokemon)
    }

    private fun getDetailPokemon(){
        for((index, data) in dataPokemon.withIndex()){
            if(!data.isLast && index >= offer) {
                data.index = index
                mViewModel.getDetailPokemon(index, data.id!!)
            }
        }
        offer += 20
    }

    override fun itemOnClick(data: ResultDataPokemon) {
        val bundle = Bundle()
        bundle.putString("data", Gson().toJson(data))
        openDetailPage(requireContext(), bundle)
    }

}
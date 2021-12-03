package com.nrchsnl.technicaltest.ui.favorite

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nrchsnl.technicaltest.MainEnvironment
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseFragment
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.di.DaggerMainComponent
import com.nrchsnl.technicaltest.di.MainDataModule
import com.nrchsnl.technicaltest.helper.extensions.setupLinearLayoutManager
import com.nrchsnl.technicaltest.ui.main.MainAdapter
import com.nrchsnl.technicaltest.ui.main.MainFragment
import com.nrchsnl.technicaltest.ui.main.MainListener
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class FavoriteFragment: BaseFragment<FavoriteViewModel>(), MainListener {

    private lateinit var mainAdapter: MainAdapter

    companion object {
        fun newInstance(bundle: Bundle): FavoriteFragment {
            return FavoriteFragment().apply {
                arguments = bundle
            }
        }
    }

    var dataPokemon = ArrayList<ResultDataPokemon>()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel: FavoriteViewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)[FavoriteViewModel::class.java]
    }

    override fun getLayoutRes(): Int = R.layout.fragment_favorite

    override fun onCreateInjector() {
        DaggerMainComponent.builder()
            .mainDataModule(MainDataModule(requireContext()))
            .build()
            .inject(this)
    }

    override fun onCreateViewModel(): FavoriteViewModel = mViewModel


    override fun setContentData() {
        mViewModel.getListPokemon()
    }

    override fun onCreateObserver(viewModel: FavoriteViewModel) {
        viewModel.run {
            listPokemon.observe(this@FavoriteFragment, Observer {
                dataPokemon = it as ArrayList<ResultDataPokemon>
                setUpList()
            })
            updateDetail.observe(this@FavoriteFragment, Observer {
                update(it)
            })
        }
    }

    override fun itemOnClick(data: ResultDataPokemon) {
        val bundle = Bundle()
        bundle.putString("data", Gson().toJson(data))
        MainEnvironment.routeNavigation.openDetailPage(requireContext(), bundle)
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
        mainAdapter.setRecyclerData(dataPokemon)
    }

    private fun getDetailPokemon(){
        for((index, data) in dataPokemon.withIndex()){
            if(!data.isLast) {
                data.index = index
                mViewModel.getDetailPokemon(index, data.id!!)
            }
        }
    }
}
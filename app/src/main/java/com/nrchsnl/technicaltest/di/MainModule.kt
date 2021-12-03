package com.nrchsnl.technicaltest.di

/**
 * Created by deannrchsnl on 25/10/21.
 */
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nrchsnl.technicaltest.base.BaseModule
import com.nrchsnl.technicaltest.base.viewmodel.ViewModelFactory
import com.nrchsnl.technicaltest.base.viewmodel.ViewModelKey
import com.nrchsnl.technicaltest.ui.detail.DetailViewModel
import com.nrchsnl.technicaltest.ui.favorite.FavoriteViewModel
import com.nrchsnl.technicaltest.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class MainModule{
    @MainScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    internal abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel
}
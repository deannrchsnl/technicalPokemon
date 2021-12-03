package com.nrchsnl.technicaltest.di

/**
 * Created by deannrchsnl on 25/10/21.
 */
import com.nrchsnl.technicaltest.ui.detail.DetailFragment
import com.nrchsnl.technicaltest.ui.favorite.FavoriteFragment
import com.nrchsnl.technicaltest.ui.main.MainFragment
import dagger.Component

@Component(modules = [
    MainDataModule::class,
    MainModule::class
])
@MainScope
interface MainComponent {
    fun inject(fragment: MainFragment)
    fun inject(fragment: DetailFragment)
    fun inject(fragment: FavoriteFragment)
}
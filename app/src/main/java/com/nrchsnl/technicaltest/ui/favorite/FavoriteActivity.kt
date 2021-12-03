package com.nrchsnl.technicaltest.ui.favorite

import android.os.Bundle
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseActivity
import com.nrchsnl.technicaltest.ui.main.MainFragment

class FavoriteActivity : BaseActivity() {
    override fun getLayoutRes(): Int = R.layout.activity_home

    override fun setContentData() {
        showFragment()
    }

    private fun showFragment() {
        val bundle = Bundle()
        val fragment = FavoriteFragment.newInstance(bundle)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
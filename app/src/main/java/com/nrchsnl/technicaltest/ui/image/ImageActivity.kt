package com.nrchsnl.technicaltest.ui.image

import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseActivity
import com.nrchsnl.technicaltest.data.remote.model.pokemon.datapokemon.ResultDataPokemon
import com.nrchsnl.technicaltest.helper.extensions.setImageUrl
import com.nrchsnl.technicaltest.helper.extensions.setupLinearLayoutManager
import kotlinx.android.synthetic.main.fragment_image.*
import kotlinx.android.synthetic.main.item_image.view.*

class ImageActivity : BaseActivity(), ImageListener {
    override fun getLayoutRes(): Int = R.layout.fragment_image

    private lateinit var imageAdapter: ImageAdapter

    var dataPokemon = ResultDataPokemon()

    var listImage = ArrayList<String>()

    override fun setContentData() {
    var datas = intent.getStringExtra("data")
        if (datas != null) {
            dataPokemon = Gson().fromJson(datas, ResultDataPokemon::class.java)
            ivParent.setImageUrl(dataPokemon.sprites?.other?.officialArtwork?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.other?.officialArtwork?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.backDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationI?.redBlue?.backDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationI?.redBlue?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationIi?.crystal?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationIii?.emerald?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationIv?.diamondPearl?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationV?.blackWhite?.animated?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationVi?.omegarubyAlphasapphire?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationVii?.icons?.frontDefault.toString())
            listImage.add(dataPokemon.sprites?.versions?.generationViii?.icons?.frontDefault.toString())
        }

        imageAdapter = ImageAdapter(this)
        rvImage.apply {
            setHasFixedSize(true)
            setupLinearLayoutManager(RecyclerView.VERTICAL, false)
            adapter = imageAdapter
        }
        imageAdapter.setRecyclerData(listImage)

        ivClose.setOnClickListener { finish() }
    }

    override fun onclickImage(url: String) {
        ivParent.setImageUrl(url)
    }
}
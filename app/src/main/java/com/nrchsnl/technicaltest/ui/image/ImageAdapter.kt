package com.nrchsnl.technicaltest.ui.image

import android.view.View
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.base.BaseAdapter
import com.nrchsnl.technicaltest.helper.extensions.setImageUrl
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter(private val mListener: ImageListener) : BaseAdapter<String>() {
    override val layout: Int = R.layout.item_image
    override fun bind(data: String, itemView: View, position: Int) {
        itemView.apply {
            ivChar.setImageUrl(data)
            ivChar.setOnClickListener {
                mListener.onclickImage(data)
            }
        }
    }

}
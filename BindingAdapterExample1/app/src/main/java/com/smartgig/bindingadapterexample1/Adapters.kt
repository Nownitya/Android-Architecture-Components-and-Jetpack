package com.smartgig.bindingadapterexample1

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

//class Adapters {
//}

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url: String) {
    Glide.with(this.context).load(url).into(this)

}
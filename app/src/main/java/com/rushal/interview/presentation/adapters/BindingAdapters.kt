package com.rushal.interview.presentation.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


/**
 *created by Ronnie Otieno on 04-Apr-21.
 **/

@BindingAdapter("imageFromUrl", "shouldRound")
fun bindImageFromUrl(view: ImageView, imageUrl: String?, shouldRound: Boolean) {
    if (!imageUrl.isNullOrEmpty()) {
        val pic = Picasso.get()
            .load(imageUrl)
            .into(view);
    }
}
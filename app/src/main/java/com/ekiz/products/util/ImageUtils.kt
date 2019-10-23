package com.ekiz.products.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ekiz.products.R

class ImageUtils {
    companion object {
        fun loadImageToImageView(context: Context, imageUrl: String?, imageView: AppCompatImageView) {
            val requestOptions =
                RequestOptions().placeholder(ColorDrawable(Color.BLACK)).error(R.drawable.ic_placeholder)
            Glide.with(context).applyDefaultRequestOptions(requestOptions).load(imageUrl).into(imageView)
        }
    }
}
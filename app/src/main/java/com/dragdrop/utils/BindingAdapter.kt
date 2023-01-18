package com.dragdrop.utils

import android.widget.ImageView

object BindingAdapter {

    @androidx.databinding.BindingAdapter("setDrawable", requireAll = false)
    @JvmStatic
    fun setImageDrawable(view:ImageView,drawable: Int){
        view.setImageResource(drawable)
    }
}
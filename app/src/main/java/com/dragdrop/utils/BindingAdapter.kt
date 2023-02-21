package com.dragdrop.utils

import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

object BindingAdapter {

    @androidx.databinding.BindingAdapter("setDrawable", requireAll = false)
    @JvmStatic
    fun setImageDrawable(view: ImageView, drawable: Int) {
        view.setImageResource(drawable)
    }

    @androidx.databinding.BindingAdapter("setLottie", requireAll = false)
    @JvmStatic
    fun setLotties(view: LottieAnimationView, raw: Int) {
        view.setAnimation(raw)
    }
}
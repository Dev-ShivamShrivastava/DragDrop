package com.dragdrop.views.fragment.home

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.dragdrop.R

class HomeVM:ViewModel() {

    fun onClick(view: View){
        when(view.id){
            R.id.ivSetting -> {
                view.findNavController().navigate(R.id.homeToSetting)
            }
        }
    }
}
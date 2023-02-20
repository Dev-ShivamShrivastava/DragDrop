package com.dragdrop.views.fragment.settings

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.dragdrop.R

class SettingsVM:ViewModel(){


    fun onClick(view:View){
        when(view.id){
            R.id.ivBack -> view.findNavController().navigateUp()
            R.id.tvContactUs -> view.findNavController().navigate(R.id.settingToContactUs)
        }
    }
}
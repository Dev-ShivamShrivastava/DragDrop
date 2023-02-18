package com.dragdrop.views.fragment.dragdrop

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.dragdrop.R

class DragDropVM:ViewModel() {

    val type = ObservableField("Animals")

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.findNavController().navigateUp()
        }

    }
}
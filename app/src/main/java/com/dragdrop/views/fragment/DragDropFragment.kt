package com.dragdrop.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dragdrop.adapters.DragAdapter
import com.dragdrop.adapters.DropAdapter
import com.dragdrop.databinding.FragmentDragDropBinding
import com.dragdrop.views.activities.MainActivity

class DragDropFragment : Fragment() {

    val binding by lazy { FragmentDragDropBinding.inflate(layoutInflater) }

    private val dropAdapter by lazy { DropAdapter() }
    private val dragAdapter by lazy { DragAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MainActivity.binding.clToolbar.visibility =View.GONE
        binding.rvDrop.adapter = dropAdapter
        binding.rvDrag.adapter = dragAdapter

        val loc = IntArray(2)
        binding.clToolbar.getLocationOnScreen(loc)
//        binding.clToolbar.getW(loc)
        val x = loc[0]
        val y = loc[1]
        Log.e("yAxisa","${y}")
    }

    override fun onPause() {
        super.onPause()
        MainActivity.binding.clToolbar.visibility =View.VISIBLE
    }

}
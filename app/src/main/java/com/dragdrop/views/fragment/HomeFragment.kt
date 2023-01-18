package com.dragdrop.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dragdrop.R
import com.dragdrop.adapters.HomeAdapter
import com.dragdrop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    val adapter by lazy { HomeAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCategory.adapter = adapter
    }
}
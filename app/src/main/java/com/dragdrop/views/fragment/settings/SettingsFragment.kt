package com.dragdrop.views.fragment.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dragdrop.R
import com.dragdrop.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private val binding by lazy { FragmentSettingsBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }
    private val viewModel:SettingsVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
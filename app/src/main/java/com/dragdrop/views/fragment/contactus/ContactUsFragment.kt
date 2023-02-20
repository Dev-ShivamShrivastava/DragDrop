package com.dragdrop.views.fragment.contactus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dragdrop.R
import com.dragdrop.databinding.FragmentContactUsBinding


class ContactUsFragment : Fragment() {

    private val binding by lazy {
        FragmentContactUsBinding.inflate(layoutInflater).apply {
            model = viewModel
        }
    }

    private val viewModel: ContactUsVM by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

}
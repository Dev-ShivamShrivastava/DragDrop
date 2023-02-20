package com.dragdrop.views.fragment.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dragdrop.R
import com.dragdrop.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private val binding by lazy { FragmentSplashBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }
    private val viewModel: SplashVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animZoomIn: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in)
        val animUp: Animation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.splash_slide_from_bottom)
        val animDown: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_out)
        binding.ivLogo.startAnimation(animZoomIn)
        binding.tvAppName.startAnimation(animUp)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1400)
            binding.ivLogo.startAnimation(animDown)
        }

    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.Main).launch {
            delay(4000)
            findNavController().navigate(R.id.splashToHome)
        }
    }

}
package com.example.laza.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(2000)
            navigateTo(R.id.action_splashFragment_to_identityTypeFragment)
        }
    }
}
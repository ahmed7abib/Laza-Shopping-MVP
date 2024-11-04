package com.example.laza.features.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.data.local.shared_pref.SharedPreferenceHelper
import com.example.laza.R
import com.example.laza.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override val viewModel = BaseViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        lifecycleScope.launch {
            delay(2000)
            if (SharedPreferenceHelper.isRememberMe()) {
                navigateTo(R.id.action_splashFragment_to_home_nav)
            } else {
                navigateTo(R.id.action_splashFragment_to_accountCreationChooserFragment)
            }
        }
    }
}
package com.example.laza.features.settings

import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override val viewModel = BaseViewModel()
}
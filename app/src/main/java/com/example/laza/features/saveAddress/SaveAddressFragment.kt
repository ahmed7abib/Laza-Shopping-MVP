package com.example.laza.features.saveAddress


import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.databinding.FragmentSaveAddressBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveAddressFragment :
    BaseFragment<FragmentSaveAddressBinding>(FragmentSaveAddressBinding::inflate) {

    override val viewModel = BaseViewModel()
}
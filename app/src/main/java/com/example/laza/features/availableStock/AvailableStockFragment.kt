package com.example.laza.features.availableStock

import com.example.common.ui.BaseFragment
import com.example.common.ui.BaseViewModel
import com.example.laza.databinding.FragmentAvailableStockBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AvailableStockFragment :
    BaseFragment<FragmentAvailableStockBinding>(FragmentAvailableStockBinding::inflate) {

    override val viewModel = BaseViewModel()
}
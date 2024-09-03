package com.example.laza.productDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.laza.databinding.FragmentProductDetailsBinding
import com.example.common.BaseFragment
import com.example.laza.LazaSharedViewModel


class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private val sharedViewModel: LazaSharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        sharedViewModel.hideUnNecessaryView(false)
    }

}
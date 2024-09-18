package com.example.laza.home


import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import com.example.common.BaseFragment
import com.example.laza.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        requireActivity().onBackPressedDispatcher.addCallback {
            requireActivity().finish()
        }
    }
}
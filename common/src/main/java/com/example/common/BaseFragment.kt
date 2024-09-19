package com.example.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.ahmed.a.habib.common.R
import com.google.android.material.snackbar.Snackbar


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<BB : ViewBinding>(
    private val inflate: Inflate<BB>,
) : Fragment() {

    private var _binding: BB? = null
    val binding get() = _binding!!

    private val viewModel: BaseViewModel = BaseViewModel()

    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate.invoke(
            inflater,
            container,
            false
        )

        val frameLayout = FrameLayout(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            addView(_binding?.root)
        }

        addProgressBar(frameLayout)

        return frameLayout
    }

    private fun addProgressBar(viewGroup: ViewGroup?) {
        progressBar = ProgressBar(requireContext())
        progressBar.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        progressBar.visibility = View.GONE
        viewGroup?.addView(progressBar)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            view.showSnackBar(it.asString(requireContext()))
        }

        viewModel.isAuthError.observe(viewLifecycleOwner) {
            if (it) {
                //TODO Goto login
                //TODO Clear Shared Preference
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
        }
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun navigateTo(navigationAction: Int) {
        findNavController().navigate(navigationAction)
    }
}
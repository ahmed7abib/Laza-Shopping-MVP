package com.example.laza.features.auth.forgotPassword

import androidx.lifecycle.viewModelScope
import com.example.common.SingleMutableLiveData
import com.example.common.isValidEmail
import com.example.common.remote.ErrorMessage
import com.example.common.remote.ErrorTypes
import com.example.common.remote.Resource
import com.example.common.ui.BaseViewModel
import com.example.domain.repos.AuthRepo
import com.example.laza.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ForgetPassViewModel @Inject constructor(private val repo: AuthRepo) : BaseViewModel() {

    private var _emailSent = SingleMutableLiveData<Boolean>()
    val emailSent get() = _emailSent

    fun sendOtp(email: String) {
        if (email.isValidEmail()) {
            repo.sendOtp(email).onStart {
                handleLoading(true)
            }.map {
                when (it) {
                    is Resource.Error -> handleError(it.errorTypes)
                    is Resource.Success -> _emailSent.postValue(true)
                }
            }.launchIn(viewModelScope)
        } else {
            handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_email)))
        }
    }
}
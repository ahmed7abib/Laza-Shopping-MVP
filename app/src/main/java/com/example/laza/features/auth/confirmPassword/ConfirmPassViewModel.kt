package com.example.laza.features.auth.confirmPassword

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
class ConfirmPassViewModel @Inject constructor(private val repo: AuthRepo) : BaseViewModel() {

    private var _confirmedOtp = SingleMutableLiveData<Boolean>()
    val confirmedOtp get() = _confirmedOtp

    fun confirmOtp(email: String, otp: String) {
        if (inputValid(email, otp)) {
            repo.confirmOtp(email, otp).onStart {
                handleLoading(true)
            }.map {
                when (it) {
                    is Resource.Error -> handleError(it.errorTypes)
                    is Resource.Success -> _confirmedOtp.postValue(true)
                }
            }.launchIn(viewModelScope)
        } else {
            handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_email)))
        }
    }

    private fun inputValid(email: String, otp: String): Boolean {
        return when {
            !email.isValidEmail() -> {
                handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_email)))
                false
            }

            otp.isEmpty() -> {
                handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_otp)))
                false
            }

            else -> true
        }
    }
}
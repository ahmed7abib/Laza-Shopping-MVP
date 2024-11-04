package com.example.laza.features.login

import androidx.lifecycle.viewModelScope
import com.example.common.SingleMutableLiveData
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
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepo
) : BaseViewModel() {

    private var _isLoginSuccess: SingleMutableLiveData<Boolean> = SingleMutableLiveData()
    val isLoginSuccess get() = _isLoginSuccess

    fun login(username: String, password: String) {
        if (isValidLoginData(username, password)) {
            authRepository.login(username, password).onStart {
                handleLoading(true)
            }.map {
                when (it) {
                    is Resource.Error -> {
                        handleLoading(false)
                        handleError(it.errorTypes)
                    }

                    is Resource.Success -> {
                        handleLoading(false)
                        _isLoginSuccess.postValue(true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun isValidLoginData(username: String, password: String): Boolean {
        return when {
            username.isEmpty() && password.isEmpty() -> {
                handleError(
                    ErrorTypes.GeneralError(
                        ErrorMessage.StringResource(
                            R.string.username_and_password_empty
                        )
                    )
                )
                false
            }

            username.isEmpty() -> {
                handleError(
                    ErrorTypes.GeneralError(
                        ErrorMessage.StringResource(
                            R.string.empty_username
                        )
                    )
                )
                false
            }

            password.isEmpty() -> {
                handleError(
                    ErrorTypes.GeneralError(
                        ErrorMessage.StringResource(
                            R.string.empty_password
                        )
                    )
                )
                false
            }

            else -> {
                true
            }
        }
    }
}
package com.example.laza.features.auth.changePassword

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
class ResetPassViewModel @Inject constructor(private val repo: AuthRepo) : BaseViewModel() {

    private var _passChanged = SingleMutableLiveData<Boolean>()
    val passChanged get() = _passChanged

    fun resetPass(email: String, newPass: String, confirmedNewPass: String) {
        if (inputValid(email, newPass, confirmedNewPass)) {
            repo.resetPass(email, newPass).onStart {
                handleLoading(true)
            }.map {
                when (it) {
                    is Resource.Error -> handleError(it.errorTypes)
                    is Resource.Success -> _passChanged.postValue(true)
                }
            }.launchIn(viewModelScope)
        } else {
            handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_email)))
        }
    }

    private fun inputValid(email: String, newPass: String, confirmedNewPass: String): Boolean {
        return when {
            newPass.isEmpty() -> {
                handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_pass)))
                false
            }

            newPass != confirmedNewPass -> {
                handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.pass_new_pass_not_match)))
                false
            }

            !email.isValidEmail() -> {
                handleError(ErrorTypes.GeneralError(ErrorMessage.StringResource(R.string.invalid_email)))
                false
            }

            else -> true
        }
    }
}
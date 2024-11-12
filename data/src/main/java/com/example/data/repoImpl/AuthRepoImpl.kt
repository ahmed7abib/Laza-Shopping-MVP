package com.example.data.repoImpl

import com.example.common.remote.BaseRemoteDataSource
import com.example.common.remote.ErrorMessage
import com.example.common.remote.ErrorTypes
import com.example.common.remote.Resource
import com.example.data.local.shared_pref.SharedPreferenceHelper
import com.example.data.remote.api.API
import com.example.data.remote.models.requests.RegisterRequest
import com.example.domain.models.holders.RegisterDataHolder
import com.example.domain.repos.AuthRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepoImpl(private val api: API) : AuthRepo, BaseRemoteDataSource() {

    override fun login(username: String, password: String) = safeApiCall {
        api.login(username, password)
    }.map {
        when (it) {
            is Resource.Error -> Resource.Error(it.errorTypes)
            is Resource.Success -> {
                if (it.data?.status?.statusCode == 0) {
                    SharedPreferenceHelper.saveUser(it.data?.user?.toDto())
                    SharedPreferenceHelper.saveToken(it.data?.token.orEmpty())
                    Resource.Success(true)
                } else {
                    Resource.Error(
                        ErrorTypes.GeneralError(
                            errorMessage = ErrorMessage.DynamicString(
                                it.data?.status?.statusMessage.orEmpty()
                            )
                        )
                    )
                }
            }
        }
    }

    override fun register(requestHolder: RegisterDataHolder) = safeApiCall {
        api.register(
            RegisterRequest(
                username = requestHolder.username,
                password = requestHolder.password,
                email = requestHolder.email
            )
        )
    }.map {
        when (it) {
            is Resource.Error -> Resource.Error(it.errorTypes)
            is Resource.Success -> {
                if (it.data?.status?.statusCode == 0) {
                    SharedPreferenceHelper.saveUser(it.data?.user?.toDto())
                    SharedPreferenceHelper.saveToken(it.data?.token.orEmpty())
                    Resource.Success(true)
                } else {
                    Resource.Error(
                        ErrorTypes.GeneralError(
                            errorMessage = ErrorMessage.DynamicString(
                                it.data?.status?.statusMessage.orEmpty()
                            )
                        )
                    )
                }
            }
        }
    }

    override fun sendOtp(email: String) = safeApiCall {
        api.sendOtp(email)
    }.map {
        when (it) {
            is Resource.Error -> Resource.Error(it.errorTypes)
            is Resource.Success -> {
                if (it.data?.statusCode == 0) {
                    Resource.Success(true)
                } else {
                    Resource.Error(
                        ErrorTypes.GeneralError(
                            errorMessage = ErrorMessage.DynamicString(
                                it.data?.statusMessage.orEmpty()
                            )
                        )
                    )
                }
            }
        }
    }

    override fun confirmOtp(
        email: String,
        otp: String
    ) = safeApiCall {
        api.confirmOtp(email, otp)
    }.map {
        when (it) {
            is Resource.Error -> Resource.Error(it.errorTypes)
            is Resource.Success -> {
                if (it.data?.statusCode == 0) {
                    Resource.Success(true)
                } else {
                    Resource.Error(
                        ErrorTypes.GeneralError(
                            errorMessage = ErrorMessage.DynamicString(
                                it.data?.statusMessage.orEmpty()
                            )
                        )
                    )
                }
            }
        }
    }

    override fun resetPass(
        email: String,
        newPass: String
    ) = safeApiCall {
        api.resetPass(email, newPass)
    }.map {
        when (it) {
            is Resource.Error -> Resource.Error(it.errorTypes)
            is Resource.Success -> {
                if (it.data?.statusCode == 0) {
                    Resource.Success(true)
                } else {
                    Resource.Error(
                        ErrorTypes.GeneralError(
                            errorMessage = ErrorMessage.DynamicString(
                                it.data?.statusMessage.orEmpty()
                            )
                        )
                    )
                }
            }
        }
    }
}
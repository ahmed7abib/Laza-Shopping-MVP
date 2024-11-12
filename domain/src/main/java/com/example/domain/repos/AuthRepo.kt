package com.example.domain.repos

import com.example.common.remote.Resource
import com.example.domain.models.holders.RegisterDataHolder
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    fun login(username: String, password: String): Flow<Resource<Boolean>>

    fun register(requestHolder: RegisterDataHolder): Flow<Resource<Boolean>>

    fun sendOtp(email: String): Flow<Resource<Boolean>>

    fun confirmOtp(email: String, otp: String): Flow<Resource<Boolean>>

    fun resetPass(email: String, newPass: String): Flow<Resource<Boolean>>
}
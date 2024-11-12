package com.example.data.remote.api

import com.example.data.remote.api.EndPoints.CONFIRM_OTP
import com.example.data.remote.api.EndPoints.LOGIN
import com.example.data.remote.api.EndPoints.REGISTER
import com.example.data.remote.api.EndPoints.RESET_PASS
import com.example.data.remote.api.EndPoints.SEND_OTP
import com.example.data.remote.models.requests.RegisterRequest
import com.example.data.remote.models.responses.AuthResponse
import com.example.data.remote.models.responses.Status
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @GET(LOGIN)
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<AuthResponse>

    @POST(REGISTER)
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @GET(SEND_OTP)
    suspend fun sendOtp(@Query("email") email: String): Response<Status>

    @GET(CONFIRM_OTP)
    suspend fun confirmOtp(
        @Query("email") email: String,
        @Query("otp") otp: String
    ): Response<Status>

    @GET(RESET_PASS)
    suspend fun resetPass(
        @Query("email") email: String,
        @Query("newPass") newPass: String
    ): Response<Status>
}
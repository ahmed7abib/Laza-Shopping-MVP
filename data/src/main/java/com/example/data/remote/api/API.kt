package com.example.data.remote.api

import com.example.data.remote.api.EndPoints.LOGIN
import com.example.data.remote.api.EndPoints.REGISTER
import com.example.data.remote.models.requests.RegisterRequest
import com.example.data.remote.models.responses.AuthResponse
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
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<AuthResponse>
}
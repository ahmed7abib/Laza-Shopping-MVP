package com.example.data.remote.models.responses

import com.example.domain.models.dto.UserDto
import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("status")
    val status: Status,
    @SerializedName("token")
    val token: String,
    @SerializedName("token")
    val user: User
)

data class User(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String
) {
    fun toDto(): UserDto {
        return UserDto(
            userId = userId,
            username = username,
            password = password,
            email = email
        )
    }
}

data class Status(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("statusMessage")
    val statusMessage: String
)
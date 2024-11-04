package com.example.domain.models.dto

data class UserDto(
    val userId: Int,
    val username: String,
    val password: String,
    val email: String
)
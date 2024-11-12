package com.example.data.remote.api

import com.example.data.BuildConfig

object EndPoints {
    const val BASE_URL = BuildConfig.BASE_URL
    const val LOGIN = "auth/login"
    const val REGISTER = "auth/register"
    const val SEND_OTP = "auth/sendOtp"
    const val CONFIRM_OTP = "auth/confirmOtp"
    const val RESET_PASS = "auth/updatePass"
}
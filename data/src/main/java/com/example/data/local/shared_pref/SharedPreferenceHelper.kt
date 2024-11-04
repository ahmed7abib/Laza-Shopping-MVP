package com.example.data.local.shared_pref

import android.content.Context
import android.content.SharedPreferences
import com.example.data.local.shared_pref.PreferenceKeys.PREFS_NAME
import com.example.data.local.shared_pref.PreferenceKeys.TOKEN_KEY
import com.example.data.local.shared_pref.PreferenceKeys.USER_KEY
import com.example.domain.models.dto.UserDto
import com.google.gson.Gson

object SharedPreferenceHelper {

    private val gson by lazy { Gson() }
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveUser(user: UserDto?) {
        val userJson = gson.toJson(user)
        preferences.edit().putString(USER_KEY, userJson).apply()
    }

    fun getUser(): UserDto? {
        val userJson = preferences.getString(USER_KEY, null)
        return userJson?.let { gson.fromJson(it, UserDto::class.java) }
    }

    fun saveToken(token: String) {
        preferences.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String? {
        return preferences.getString(TOKEN_KEY, null)
    }

    fun clear() {
        preferences.edit().clear().apply()
    }
}
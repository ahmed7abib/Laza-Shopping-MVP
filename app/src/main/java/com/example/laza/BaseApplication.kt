package com.example.laza

import android.app.Application
import com.example.data.local.shared_pref.SharedPreferenceHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPreferenceHelper.init(applicationContext)
    }
}
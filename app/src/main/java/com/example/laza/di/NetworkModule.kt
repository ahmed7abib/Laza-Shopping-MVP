package com.example.laza.di

import android.content.Context
import com.example.common.remote.InternetInterceptor
import com.example.data.local.shared_pref.SharedPreferenceHelper
import com.example.data.remote.api.API
import com.example.data.remote.api.EndPoints
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(client: OkHttpClient): API {
        return Retrofit.Builder()
            .baseUrl(EndPoints.BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(API::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        interceptor: HttpLoggingInterceptor,
        internetInterceptor: InternetInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(15, TimeUnit.SECONDS)
            readTimeout(15, TimeUnit.SECONDS)
            addInterceptor(interceptor)
            addInterceptor(internetInterceptor)
            addInterceptor { chain ->
                val request: Request =
                    chain.request()
                        .newBuilder()
                        .addHeader("Authorization", SharedPreferenceHelper.getToken().orEmpty())
                        .build()
                chain.proceed(request)
            }
        }.build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideInternetInterceptor(@ApplicationContext context: Context): InternetInterceptor {
        return InternetInterceptor(context)
    }
}
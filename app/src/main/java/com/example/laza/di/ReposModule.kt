package com.example.laza.di

import com.example.data.remote.api.API
import com.example.data.repoImpl.AuthRepoImpl
import com.example.domain.repos.AuthRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object ReposModule {

    @Provides
    fun provideAuthRepo(api: API): AuthRepo {
        return AuthRepoImpl(api)
    }
}
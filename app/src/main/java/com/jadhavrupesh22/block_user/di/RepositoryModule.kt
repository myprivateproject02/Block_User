package com.jadhavrupesh22.hiltbase.di

import com.jadhavrupesh22.block_user.repo.MainRepository
import com.jadhavrupesh22.block_user.retrofit.AlbumService
import com.jadhavrupesh22.hiltbase.retrofit.JsonPlaceholderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        jsonPlaceholderApi: JsonPlaceholderApi,
        albumService: AlbumService
    ): MainRepository {
        return MainRepository(jsonPlaceholderApi,albumService)
    }

}
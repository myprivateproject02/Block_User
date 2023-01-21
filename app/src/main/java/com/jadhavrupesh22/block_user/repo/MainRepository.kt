package com.jadhavrupesh22.block_user.repo


import com.jadhavrupesh22.block_user.model.Post

import com.jadhavrupesh22.block_user.retrofit.AlbumService
import com.jadhavrupesh22.hiltbase.retrofit.JsonPlaceholderApi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class MainRepository
constructor(
    val jsonPlaceholderApi: JsonPlaceholderApi,
    val albumService: AlbumService
) {

    fun getPost(): Flow<List<Post>> = flow {
        val response = jsonPlaceholderApi.getPosts()
        emit(response)
    }.flowOn(Dispatchers.IO)


}




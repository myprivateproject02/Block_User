package com.jadhavrupesh22.block_user.model

import com.google.gson.annotations.Expose

data class Post(
    @Expose
    val body: String,
    @Expose
    val id: Int,
    @Expose
    val title: String,
    @Expose
    val userId: Int
)
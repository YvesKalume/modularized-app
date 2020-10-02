package com.yvkalume.model.api

import com.yvkalume.model.entity.Post
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts() : List<Post>
}
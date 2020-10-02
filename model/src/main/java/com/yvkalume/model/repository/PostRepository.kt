package com.yvkalume.model.repository

import com.yvkalume.model.api.PostApi
import com.yvkalume.model.entity.Post
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class PostRepository(private val api: PostApi) {

    fun getPosts() = flow {
        emit(api.getPosts())
    }
}
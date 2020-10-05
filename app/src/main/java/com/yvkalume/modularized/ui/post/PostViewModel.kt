package com.yvkalume.modularized.ui.post

import com.airbnb.mvrx.MavericksViewModel
import com.yvkalume.model.repository.PostRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class PostViewModel(
    initialState: PostState
) : MavericksViewModel<PostState>(initialState), KoinComponent {
    private val repository: PostRepository by inject()

    init {
        getData()
    }

    private fun getData() {
        repository.getPosts().execute {
            copy(post = it)
        }
    }
}
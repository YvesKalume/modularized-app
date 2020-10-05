package com.yvkalume.modularized.ui.post

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.yvkalume.model.entity.Post

data class PostState(
    val post: Async<List<Post>> = Uninitialized
) : MavericksState
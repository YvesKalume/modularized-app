package com.yvkalume.modularized.ui.post

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yvkalume.model.entity.Post
import com.yvkalume.model.repository.PostRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = _posts

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                repository.getPosts().collect {
                    _posts.postValue(it)
                }
            } catch (t: Throwable) {
                Log.d("PostViewModel","erreur : ${t.message}")
            }
        }
    }
}
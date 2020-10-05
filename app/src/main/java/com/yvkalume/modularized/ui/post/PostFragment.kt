package com.yvkalume.modularized.ui.post

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.airbnb.mvrx.*
import com.yvkalume.model.entity.Post
import com.yvkalume.modularized.adapter.OnItemClickListener
import com.yvkalume.modularized.adapter.PostAdapter
import com.yvkalume.modularized.databinding.FragmentPostBinding

class PostFragment : Fragment(), OnItemClickListener, MavericksView {
    private val binding by lazy { FragmentPostBinding.inflate(layoutInflater) }
    private val adapter by lazy { PostAdapter(this) }

    private val postViewModel: PostViewModel by fragmentViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onItemClick(post: Post) {
        Toast.makeText(context,post.title,Toast.LENGTH_SHORT).show()
    }

    override fun invalidate(): Unit = withState(postViewModel) {
        binding.progess.isVisible = it.post is Loading
        when (it.post) {
            is Success -> {
                binding.progess.visibility = View.GONE
                adapter.submitList(it.post.invoke())
            }
            is Fail -> {
                Log.e("message", it.post.error.localizedMessage)
            }
        }
    }
}
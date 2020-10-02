package com.yvkalume.modularized.ui.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.yvkalume.model.entity.Post
import com.yvkalume.modularized.R
import com.yvkalume.modularized.adapter.OnItemClickListener
import com.yvkalume.modularized.adapter.PostAdapter
import com.yvkalume.modularized.databinding.FragmentPostBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostFragment : Fragment(), OnItemClickListener {
    private val binding by lazy { FragmentPostBinding.inflate(layoutInflater) }
    private val postViewModel by viewModel<PostViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = PostAdapter(this)
        postViewModel.posts.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onItemClick(post: Post) {
        Toast.makeText(context,post.title,Toast.LENGTH_SHORT).show()
    }
}
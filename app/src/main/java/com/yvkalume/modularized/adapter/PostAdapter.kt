package com.yvkalume.modularized.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yvkalume.model.entity.Post
import com.yvkalume.modularized.databinding.ItemPostBinding

class PostAdapter(private val clickListener: OnItemClickListener) : ListAdapter<Post, PostAdapter.PostViewHolder>(Companion) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(layoutInflater,parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = getItem(position)
        val binding = holder.binding
        binding.apply {
            post = currentPost
            root.setOnClickListener {
                clickListener.onItemClick(currentPost)
            }
        }
    }
    companion object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

    }
    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)
}

interface OnItemClickListener {
    fun onItemClick(post: Post)
}
package com.example.maggy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maggy.databinding.ListPostBinding

class PostAdapter(var posts : List<PostItem>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
      val inflater = LayoutInflater.from(parent.context)
        val binding = ListPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun updatePosts(newPosts: List<PostItem>) {
        posts = newPosts
        notifyDataSetChanged() // Not optimal for large datasets, consider using DiffUtil for efficiency
    }

    class PostViewHolder(val binding: ListPostBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(post : PostItem){
            binding.post = post
            binding.executePendingBindings()
        }

    }
}
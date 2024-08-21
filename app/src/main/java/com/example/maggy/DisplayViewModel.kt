package com.example.maggy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DisplayViewModel(private val repo: Repo) : ViewModel() {

    private val _posts = MutableLiveData<List<PostItem>>()
    val posts: LiveData<List<PostItem>> get() = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val postItem = repo.getPosts()
                _posts.postValue(postItem)
            } catch (e: Exception) {
                println("Error encountered: ${e.message}")
            }
        }
    }
}

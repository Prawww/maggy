package com.example.maggy

class Repo(private val apiService: ApiService) {

    suspend fun getPosts(): List<PostItem> {
        return apiService.getPosts()
    }

    suspend fun getPost(id: Long): PostItem {
        return apiService.getPost(id)
    }
}

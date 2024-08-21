package com.example.maggy

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostItem>

    @GET("posts")
    suspend fun getPost(@Query("id") id: Long): PostItem

    @PATCH("posts/{id}")
    suspend fun patchPost(
        @Path("id") id: Int,
        @Body fields: Map<String, String>
    ): PostItem
}
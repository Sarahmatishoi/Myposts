package com.example.mypostsy

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts():retrofit2.Call<List<Post>>

    @GET("posts/{postId}")
    fun getPost(@Path("postId")postId:Int) :retrofit2.Call<Post>
   fun getComments(@Path("postId") id: ApiInterface):retrofit2.Call<List<Comments>>
}
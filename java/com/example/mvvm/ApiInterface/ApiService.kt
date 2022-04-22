package com.example.mvvm.ApiInterface

import com.example.mvvm.model.PostsModel
import com.example.mvvm.model.todoListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    suspend fun getPosts():Response<PostsModel>


    @GET("todos")
    suspend fun getTodos(@Query("page") page:Int):Response<todoListModel>
}
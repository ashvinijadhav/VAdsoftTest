package com.example.vadsofttest.model


import retrofit2.Call
import retrofit2.http.GET


interface API {

    @GET("jet2/api/v1/blogs?page=1,limit=10")
    fun getArticles(): Call<List<APIResponce>>

}

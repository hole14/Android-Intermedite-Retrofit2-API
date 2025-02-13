package com.example.myretrofit2api.data.retrofit

import com.example.myretrofit2api.data.response.ListDoaResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("api/doa/v1/random")
    fun getRandomDoa(): Call<ListDoaResponse>
}
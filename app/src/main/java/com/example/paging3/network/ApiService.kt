package com.example.paging3.network


import com.example.paging3.response.RickMortyResponse
import com.example.paging3.response.newResponse.NewAPiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("character")
    suspend fun callApi(
        @Query("page") page:Int
    ):NewAPiResponse

}
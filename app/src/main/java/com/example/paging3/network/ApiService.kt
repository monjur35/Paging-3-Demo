package com.example.paging3.network

import android.telecom.Call
import com.example.paging3.response.RickMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("character")
    suspend fun callApi(
        @Query("page") page:Int
    ):RickMortyResponse

}
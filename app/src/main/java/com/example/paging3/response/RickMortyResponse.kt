package com.example.paging3.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class RickMortyResponse {
    @SerializedName("info")
    @Expose
    var info: Info? = null

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
}
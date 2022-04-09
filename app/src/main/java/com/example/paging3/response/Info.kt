package com.example.paging3.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Info(

    var count: Int,

    var pages: String,


    var next: String,
    var prev: String
)
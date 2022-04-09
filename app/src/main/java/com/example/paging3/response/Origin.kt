package com.example.paging3.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Origin (

    var name: String,
    var url: String? = null
)
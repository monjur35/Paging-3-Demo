package com.example.paging3.response.newResponse

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)
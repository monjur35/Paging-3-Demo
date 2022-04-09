package com.example.paging3.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Location {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}
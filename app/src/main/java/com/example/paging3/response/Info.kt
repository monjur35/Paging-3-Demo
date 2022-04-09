package com.example.paging3.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Info {
    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("pages")
    @Expose
    var pages: Int? = null

    @SerializedName("next")
    @Expose
    var next: String? = null

    @SerializedName("prev")
    @Expose
    var prev: Any? = null
}
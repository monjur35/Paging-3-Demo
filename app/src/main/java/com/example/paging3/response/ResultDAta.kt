package com.example.paging3.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ResultDAta (

    var id: Int?,
    var name: String?,
    var status: String?,
    var species: String?,
    var type: String?,
    var gender: String?,
    var origin: Origin,
    var location: Location,
    var image: String?,
    var episode: List<String>,
    var url: String,
    var created: String,
)
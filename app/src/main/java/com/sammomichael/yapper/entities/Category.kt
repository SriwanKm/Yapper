package com.sammomichael.yapper.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    var alias: String? = "",
    var title: String? = ""
)
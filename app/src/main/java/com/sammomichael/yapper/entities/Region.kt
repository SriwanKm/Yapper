package com.sammomichael.yapper.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Region(
    var center: Center? = Center()
)
package com.sammomichael.yapper.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinates(
    var latitude: Double? = 0.0,
    var longitude: Double? = 0.0
)
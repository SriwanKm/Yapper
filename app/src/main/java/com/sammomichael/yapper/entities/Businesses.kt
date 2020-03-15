package com.sammomichael.yapper.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Businesses(
    var businesses: List<Businesse?>? = listOf(),
    var region: Region? = Region(),
    var total: Int? = 0
)
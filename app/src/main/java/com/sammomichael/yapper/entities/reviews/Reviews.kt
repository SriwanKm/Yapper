package com.sammomichael.yapper.entities.reviews


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Reviews(
    @Json(name = "possible_languages")
    var possibleLanguages: List<String?>? = listOf(),
    var reviews: List<Review?>? = listOf(),
    var total: Int? = 0
)
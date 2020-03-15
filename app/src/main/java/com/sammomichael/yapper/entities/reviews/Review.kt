package com.sammomichael.yapper.entities.reviews


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Review(
    var id: String? = "",
    var rating: Int? = 0,
    var text: String? = "",
    @Json(name = "time_created")
    var timeCreated: String? = "",
    var url: String? = "",
    var user: User? = User()
)
package com.sammomichael.yapper.entities.reviews


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    var id: String? = "",
    @Json(name = "image_url")
    var imageUrl: Any? = Any(),
    var name: String? = "",
    @Json(name = "profile_url")
    var profileUrl: String? = ""
)
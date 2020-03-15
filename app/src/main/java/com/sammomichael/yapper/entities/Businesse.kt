package com.sammomichael.yapper.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Businesse(
    var alias: String? = "",
    var categories: List<Category?>? = listOf(),
    var coordinates: Coordinates? = Coordinates(),
    @Json(name = "display_phone")
    var displayPhone: String? = "",
    var distance: Double? = 0.0,
    var id: String? = "",
    @Json(name = "image_url")
    var imageUrl: String? = "",
    @Json(name = "is_closed")
    var isClosed: Boolean? = false,
    var location: Location? = Location(),
    var name: String? = "",
    var phone: String? = "",
    var price: String? = "",
    var rating: Double? = 0.0,
    @Json(name = "review_count")
    var reviewCount: Int? = 0,
    var transactions: List<String?>? = listOf(),
    var url: String? = ""
)
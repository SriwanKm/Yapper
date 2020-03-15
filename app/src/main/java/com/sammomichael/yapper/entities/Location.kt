package com.sammomichael.yapper.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    var address1: String? = "",
    var address2: String? = "",
    var address3: String? = "",
    var city: String? = "",
    var country: String? = "",
    @Json(name = "display_address")
    var displayAddress: List<String?>? = listOf(),
    var state: String? = "",
    @Json(name = "zip_code")
    var zipCode: String? = ""
)
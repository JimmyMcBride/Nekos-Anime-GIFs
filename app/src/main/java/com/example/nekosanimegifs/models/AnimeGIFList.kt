package com.example.nekosanimegifs.models
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class AnimeGIFList(
    @Json(name = "url")
    val urls: List<Url>
) : Serializable
//{
//    @JsonClass(generateAdapter = true)
//    data class Url(
//        @Json(name = "anime_name")
//        val animeName: String,
//
//        @Json(name = "url")
//        val url: String
//    )
//}



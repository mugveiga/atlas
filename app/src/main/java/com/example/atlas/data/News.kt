package com.example.atlas.data

import java.io.Serializable
import java.time.Instant

data class News(

    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Instant,
    val content: String

) : Serializable

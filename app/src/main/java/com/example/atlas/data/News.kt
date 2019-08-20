package com.example.atlas.data

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class News(

    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Date,
    val content: String

) : Serializable {

    fun publishedAtPretty(): String {
        return SimpleDateFormat.getDateInstance().format(publishedAt)
    }

}




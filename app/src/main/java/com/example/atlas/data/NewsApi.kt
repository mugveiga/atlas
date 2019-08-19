package com.example.atlas.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything?q=cryptocurrency&sortBy=publishedAt&apiKey=ecd76f9f8ef74a3c8cb8efb00cba089d")
    fun listNews(
        @Query("from") from: String
    ): Call<NewsResponse>

}

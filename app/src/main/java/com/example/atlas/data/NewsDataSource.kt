package com.example.atlas.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDataSource(private val newsApi: NewsApi) {

    fun listAll(from: String, success: (List<News>) -> Unit, failure: () -> Unit) {
        val call = newsApi.listNews(from)
        call.enqueue(object : Callback<NewsResponse> {

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val news = mutableListOf<News>()
                    response.body()?.articles?.forEach {
                        news.add(it)
                    }
                    success(news)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                failure()
            }
        })
    }
}

package com.example.atlas.data

import androidx.lifecycle.MutableLiveData


class NewsRepository(private val newsDataSource: NewsDataSource) {

    fun getNews(from: String): MutableLiveData<List<News>> {
        val newsList = MutableLiveData<List<News>>()
        newsDataSource.listAll(from, success = {
            newsList.value = it
        }, failure = {
            newsList.value = null
        })
        return newsList
    }

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: NewsRepository? = null

        fun getInstance(newsDataSource: NewsDataSource) =
            instance ?: synchronized(this) {
                instance ?: NewsRepository(newsDataSource).also { instance = it }
            }
    }
}

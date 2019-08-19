package com.example.atlas.utilities

import com.example.atlas.data.NewsApi
import com.example.atlas.data.NewsDataSource
import com.example.atlas.data.NewsRepository
import com.example.atlas.viewmodels.NewsListViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getNewsRepository(): NewsRepository {
        val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val newsDataSource = NewsDataSource(retrofit.create(NewsApi::class.java))
        return NewsRepository.getInstance(newsDataSource)
    }

    fun provideNewsListViewModelFactory(): NewsListViewModelFactory {
        val repository = getNewsRepository()
        return NewsListViewModelFactory(repository)
    }

}

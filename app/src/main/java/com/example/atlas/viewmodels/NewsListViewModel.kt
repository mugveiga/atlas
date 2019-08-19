package com.example.atlas.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atlas.data.News
import com.example.atlas.data.NewsRepository
import java.text.SimpleDateFormat
import java.util.*

/**
 * The ViewModel for [NewsListFragment].
 */
class NewsListViewModel internal constructor(
    newsRepository: NewsRepository
) : ViewModel() {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    val newsList: MutableLiveData<List<News>> = newsRepository.getNews(from())

    private fun from(): String {
        val from = GregorianCalendar.getInstance()
        from.add(Calendar.DAY_OF_MONTH, -20)
        return dateFormat.format(from.time)
    }

}

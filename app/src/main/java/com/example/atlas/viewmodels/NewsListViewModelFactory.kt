package com.example.atlas.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.atlas.data.NewsRepository


/**
 * Factory for creating a [NewsListViewModelOld] with a constructor that takes a [NewsRepository].
 */
class NewsListViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = NewsListViewModel(repository) as T
}

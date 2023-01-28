package com.example.lab3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.lab3.model.FeedItem
import kotlinx.coroutines.launch

class FeedItemViewModel(application: Application) : AndroidViewModel(application) {

    var readAllData: LiveData<List<FeedItem>>

    private val feedItemRepo: FeedItemRepo

    init {
        val feedItemDao = AppDb.getDb(application).feedItemDao()
        feedItemRepo = FeedItemRepo(feedItemDao)
        readAllData = feedItemRepo.readAllData
    }

    fun addFeedItem(feedItem: FeedItem) {
        viewModelScope.launch {
            feedItemRepo.insert(feedItem)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            feedItemRepo.deleteAll()
        }
    }
}
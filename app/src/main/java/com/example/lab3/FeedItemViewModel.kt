package com.example.lab3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.lab3.api.FeedItemInterface
import com.example.lab3.api.RetrofitHelper
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

    fun getExternalData() {
        val url = "http://10.0.2.2:3000"
        val retrofitClient = RetrofitHelper.getInstance(url).create(FeedItemInterface::class.java)
        viewModelScope.launch {
            try {
                val response = retrofitClient.getItems()
                if (response.isSuccessful) {
                    response.body()?.let { feedItemRepo.insert(it) }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
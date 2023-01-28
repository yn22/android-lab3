package com.example.lab3

import androidx.lifecycle.LiveData
import com.example.lab3.dao.FeedItemDao
import com.example.lab3.model.FeedItem

class FeedItemRepo(private val feedItemDao: FeedItemDao) {

    val readAllData : LiveData<List<FeedItem>> = feedItemDao.getAll()

    suspend fun getAll(): LiveData<List<FeedItem>> {
        return feedItemDao.getAll()
    }

    suspend fun insert(feedItem: FeedItem) {
        feedItemDao.insert(feedItem)
    }

    suspend fun deleteAll() {
        feedItemDao.deleteAll()
    }
}
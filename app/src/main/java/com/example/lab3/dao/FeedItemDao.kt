package com.example.lab3.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lab3.model.FeedItem

@Dao
interface FeedItemDao {
    @Query("SELECT * FROM feed_items")
    fun getAll(): LiveData<List<FeedItem>>

    @Insert
    suspend fun insert(feedItem: FeedItem);

    @Query("DELETE FROM feed_items")
    suspend fun deleteAll();
}
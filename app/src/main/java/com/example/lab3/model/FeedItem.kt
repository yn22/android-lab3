package com.example.lab3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feed_items")
data class FeedItem(
    val title: String,
    val description: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}

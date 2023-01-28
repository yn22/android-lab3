package com.example.lab3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab3.dao.FeedItemDao
import com.example.lab3.model.FeedItem

@Database(entities = [FeedItem::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun feedItemDao(): FeedItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getDb(context: Context): AppDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "app_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
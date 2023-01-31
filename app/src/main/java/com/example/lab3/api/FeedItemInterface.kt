package com.example.lab3.api

import com.example.lab3.model.FeedItem
import retrofit2.Response
import retrofit2.http.GET

interface FeedItemInterface{
    @GET("/items.json")
    suspend fun getItems() : Response<ArrayList<FeedItem>>
}
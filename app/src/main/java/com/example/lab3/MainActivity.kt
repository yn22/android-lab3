package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var feedItemAdapter: FeedItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        feedItemAdapter = FeedItemAdapter()
        binding.rcView.adapter = feedItemAdapter
        binding.rcView.layoutManager = LinearLayoutManager(this)
        feedItemAdapter.setList(creteDummyFeedItems())

    }

    private fun creteDummyFeedItems() : ArrayList<FeedItem> {
        val feedItems = ArrayList<FeedItem>()
        for (i in 0..50) {
            feedItems.add(FeedItem("Title $i", "Description $i"))
        }
        return feedItems
    }
}
package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3.databinding.ActivityMainBinding
import com.example.lab3.model.FeedItem

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var feedItemAdapter: FeedItemAdapter
    lateinit var feedItemViewModel: FeedItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        binding.btnAddItem.setOnClickListener(this)
        binding.btnDeleteAll.setOnClickListener(this)

        feedItemViewModel = ViewModelProvider(this)[FeedItemViewModel::class.java]
        feedItemViewModel.readAllData.observe(this) { feedItems ->
            feedItemAdapter.setList(feedItems as ArrayList<FeedItem>)
            binding.rcView.smoothScrollToPosition(feedItems.size )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAddItem -> {
                val total = feedItemViewModel.readAllData.value?.size ?: 0
                feedItemViewModel.addFeedItem(FeedItem("Title $total", "Description $total"))
            }
            R.id.btnDeleteAll -> {
                feedItemViewModel.deleteAll()
            }
        }
    }

    private fun initRecyclerView() {
        feedItemAdapter = FeedItemAdapter()
        binding.rcView.adapter = feedItemAdapter
        binding.rcView.layoutManager = LinearLayoutManager(this)
//      feedItemAdapter.setList(creteDummyFeedItems())

    }
}
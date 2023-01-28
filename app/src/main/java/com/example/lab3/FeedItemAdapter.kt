package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.databinding.FeedItemBinding
import com.example.lab3.model.FeedItem

class FeedItemAdapter : RecyclerView.Adapter<FeedItemAdapter.FeedItemViewHolder>() {
    private var feedItems = ArrayList<FeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(feedItems[position])
    }

    override fun getItemCount(): Int {
        return feedItems.size
    }

    fun setList(feedItems: ArrayList<FeedItem>) {
        this.feedItems = feedItems
        notifyDataSetChanged()
    }

    class FeedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = FeedItemBinding.bind(itemView)
        fun bind(feedItem: FeedItem) = with(binding) {
            idTitle.text = feedItem.title
            idDescription.text = feedItem.description
        }
    }
}

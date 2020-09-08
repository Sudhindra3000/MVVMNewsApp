package com.androiddevs.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.databinding.NewsItemBinding
import com.androiddevs.mvvmnewsapp.models.Article

class NewsAdapter(private val listener: NewsItemListener) :
    ListAdapter<Article, NewsAdapter.NewsItemViewHolder>(DIFF_CALLBACK) {

    interface NewsItemListener {
        fun onItemClick(position: Int)

        fun onFavouriteClick(position: Int)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article) =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: Article, newItem: Article) =
                oldItem == newItem
        }
    }

    class NewsItemViewHolder(
        val binding: NewsItemBinding,
        private val listener: NewsItemListener
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.newsCard.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)
        return NewsItemViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.binding.article = getItem(position)
    }
}
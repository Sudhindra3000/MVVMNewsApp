package com.androiddevs.mvvmnewsapp.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) {
    companion object {
        @BindingAdapter("android:loadArticleImage")
        fun loadArticleImage(imageView: ImageView, url: String) {
            Glide.with(imageView)
                .load(url)
                .into(imageView)
        }
    }
}
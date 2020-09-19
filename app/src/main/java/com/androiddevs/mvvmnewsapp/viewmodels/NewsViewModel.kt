package com.androiddevs.mvvmnewsapp.viewmodels

import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.db.NewsRepository

class NewsViewModel(
    val repository: NewsRepository
) : ViewModel() {
}
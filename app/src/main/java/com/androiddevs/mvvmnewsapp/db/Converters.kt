package com.androiddevs.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.models.Source
import com.google.gson.Gson

class Converters {

    companion object {
        val gson = Gson()
    }

    @TypeConverter
    fun fromSource(source: Source) = gson.toJson(source)

    @TypeConverter
    fun fromString(string: String) = gson.fromJson(string, Source::class.java)
}
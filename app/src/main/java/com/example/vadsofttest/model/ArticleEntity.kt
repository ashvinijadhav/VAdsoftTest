package com.example.vadsofttest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_items")
data class ArticleEntity(
    @ColumnInfo(name = "username") var title: String,
    @ColumnInfo(name = "designation") var designation: String,
    @ColumnInfo(name = "time") var time: String,
    @ColumnInfo(name = "articletext") var articletext: String,
    @ColumnInfo(name = "likes") var likes: String,
    @ColumnInfo(name = "comments") var comments: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
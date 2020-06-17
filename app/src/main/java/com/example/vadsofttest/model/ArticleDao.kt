package com.example.vadsofttest.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ArticleDao {
    @Query("SELECT * FROM article_items ")
    fun getAll(): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg article: ArticleEntity)
}
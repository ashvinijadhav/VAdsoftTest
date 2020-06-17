package com.example.vadsofttest.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ArticleEntity::class), version = 1)
    abstract class VadAppdatabase : RoomDatabase() {
        abstract fun articleDao(): ArticleDao
        companion object {
        @Volatile
        private var INSTANCE: VadAppdatabase? = null

        fun getInstance(context: Context): VadAppdatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(VadAppdatabase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VadAppdatabase::class.java,
                    "article_database"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}

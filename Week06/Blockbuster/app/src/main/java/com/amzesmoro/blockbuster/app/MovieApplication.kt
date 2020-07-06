package com.amzesmoro.blockbuster.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.amzesmoro.blockbuster.database.MovieDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MovieApplication : Application() {

    companion object {
        lateinit var database: MovieDatabase
        private lateinit var instance: MovieApplication
        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        database = Room.databaseBuilder(this, MovieDatabase::class.java, "movie_database")
            .addCallback(RoomDatabaseCallback(coroutineScope))
            .build()
    }

    private class RoomDatabaseCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            scope.launch {

            }
        }
    }

}
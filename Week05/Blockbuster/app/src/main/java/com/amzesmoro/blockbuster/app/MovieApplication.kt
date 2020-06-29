package com.amzesmoro.blockbuster.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.amzesmoro.blockbuster.database.MovieDatabase

class MovieApplication : Application() {

    companion object {
        lateinit var database: MovieDatabase
        private lateinit var instance: MovieApplication
        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        database = Room.databaseBuilder(this, MovieDatabase::class.java, "movie_database").build()
    }

}
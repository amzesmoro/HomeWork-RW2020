package com.amzesmoro.blockbuster.app

import com.amzesmoro.blockbuster.database.RoomRepository
import com.amzesmoro.blockbuster.model.MovieRepository

object Injection {
    fun provideMovieRepository(): MovieRepository = RoomRepository()
}
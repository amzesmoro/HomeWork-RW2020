package com.amzesmoro.blockbuster.app

import com.amzesmoro.blockbuster.model.MovieRepository

object Injection {
    fun provideMovieRepository() = MovieRepository()
}
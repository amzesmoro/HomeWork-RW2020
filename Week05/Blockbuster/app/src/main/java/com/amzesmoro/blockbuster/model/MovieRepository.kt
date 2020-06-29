package com.amzesmoro.blockbuster.model

import androidx.lifecycle.LiveData

interface MovieRepository {
    fun addMovie(movie: Movie)
    fun getMovies(): LiveData<List<Movie>>
    fun clearMovie(movie: Movie)
}
package com.amzesmoro.blockbuster.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amzesmoro.blockbuster.app.Injection
import com.amzesmoro.blockbuster.model.Movie

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Injection.provideMovieRepository()
    private val allMovies = repository.getMovies()

    fun getMovies() = allMovies

    fun insert(movie: Movie) = repository.addMovie(movie)

    fun clearMovie(movie: Movie) = repository.clearMovie(movie)
}
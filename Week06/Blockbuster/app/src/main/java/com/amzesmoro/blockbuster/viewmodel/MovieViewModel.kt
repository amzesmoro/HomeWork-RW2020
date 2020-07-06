package com.amzesmoro.blockbuster.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.amzesmoro.blockbuster.app.Injection
import com.amzesmoro.blockbuster.model.Movie

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Injection.provideMovieRepository()
    private val allMovies = repository.getAllMovies()

    fun getMovies() = allMovies

    //fun insert(movies: LiveData<List<Movie>>) = repository.storeMoviesIfNotEmpty(movies)


}
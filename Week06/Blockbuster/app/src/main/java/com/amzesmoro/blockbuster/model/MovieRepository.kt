package com.amzesmoro.blockbuster.model

import androidx.lifecycle.LiveData
import com.amzesmoro.blockbuster.app.MovieApplication
import com.amzesmoro.blockbuster.database.MovieDao

class MovieRepository {

    private val movieDao: MovieDao = MovieApplication.database.movieDao()

    fun getAllMovies(): LiveData<List<Movie>> = movieDao.fetchMovies()

    fun getMovieById(movieId: Int) = movieDao.fetchMovieById(movieId)

    private fun storeMovies(movies: List<Movie>) = movieDao.storeMovies(movies)

    fun storeMoviesIfNotEmpty(movies: List<Movie>) = storeMovies(movies)

}
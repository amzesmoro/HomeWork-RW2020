package com.amzesmoro.blockbuster.database

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.amzesmoro.blockbuster.app.MovieApplication
import com.amzesmoro.blockbuster.model.Movie
import com.amzesmoro.blockbuster.model.MovieRepository

class RoomRepository : MovieRepository {

    private val movieDao: MovieDao = MovieApplication.database.movieDao()
    private val allMovies: LiveData<List<Movie>>

    init {
        allMovies = movieDao.getAllMovies()
    }

    override fun addMovie(movie: Movie) {
        InsertAsynctask(movieDao).execute(movie)
    }

    override fun getMovies() = allMovies

    override fun clearMovie(movie: Movie) {
        DeleteAsyncTask(movieDao).execute(movie)
    }

    private class InsertAsynctask internal constructor(private val dao: MovieDao) : AsyncTask<Movie, Void, Void>() {
        override fun doInBackground(vararg params: Movie): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: MovieDao) : AsyncTask<Movie, Void, Void>() {
        override fun doInBackground(vararg params: Movie): Void? {
            dao.delete(*params)
            return null
        }
    }


}
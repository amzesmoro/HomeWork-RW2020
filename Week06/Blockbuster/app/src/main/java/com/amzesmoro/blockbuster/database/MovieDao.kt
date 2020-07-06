package com.amzesmoro.blockbuster.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amzesmoro.blockbuster.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun storeMovies(movies: List<Movie>)

    @Query("SELECT * FROM movie_table WHERE id =:movieId")
    fun fetchMovieById(movieId: Int): Movie

    @Query("SELECT * FROM movie_table ORDER BY title ASC")
    fun fetchMovies(): LiveData<List<Movie>>

}
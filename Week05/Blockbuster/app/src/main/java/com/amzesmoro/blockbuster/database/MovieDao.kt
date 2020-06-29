package com.amzesmoro.blockbuster.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.amzesmoro.blockbuster.model.Movie

@Dao
interface MovieDao {
    @Insert
    fun insert(movie: Movie)

    @Delete
    fun delete(vararg movie: Movie)

    @Query("SELECT * FROM movie_table ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<Movie>>
}
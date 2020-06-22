package com.amzesmoro.blockbuster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.data.MovieData
import com.amzesmoro.blockbuster.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieRv.setHasFixedSize(true)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        movieRv.layoutManager = GridLayoutManager(this, 2)
        val cardViewMovieAdapter = MovieAdapter()
        movieRv.adapter = cardViewMovieAdapter
        val movieData = MovieData
        cardViewMovieAdapter.setMovies(movieData.getMovies)
    }
}
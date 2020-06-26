package com.amzesmoro.blockbuster.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.data.Movie
import com.amzesmoro.blockbuster.data.MovieData
import com.amzesmoro.blockbuster.ui.adapter.MovieAdapter
import com.amzesmoro.blockbuster.utils.MovieClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieRv.setHasFixedSize(true)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        movieRv.layoutManager = GridLayoutManager(this, 2)
        val cardViewMovieAdapter = MovieAdapter(this)
        movieRv.adapter = cardViewMovieAdapter
        val movieData = MovieData
        cardViewMovieAdapter.setMovies(movieData.getMovies)
    }

    override fun itemClickLister(movie: Movie) {
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
        startActivity(detailIntent)

    }
}
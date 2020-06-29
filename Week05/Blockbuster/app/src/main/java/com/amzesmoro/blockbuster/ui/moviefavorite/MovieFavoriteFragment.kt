package com.amzesmoro.blockbuster.ui.moviefavorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.utils.listMovies
import kotlinx.android.synthetic.main.fragment_movie_favorite.*

class MovieFavoriteFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewMovieFavorite()
    }

    private fun initRecyclerViewMovieFavorite() {
        movieFavoriteRv.setHasFixedSize(true)
        movieFavoriteRv.layoutManager = LinearLayoutManager(context)
        val movieFavoriteAdapter = MovieFavoriteAdapter()
        movieFavoriteRv.adapter = movieFavoriteAdapter
        //movieFavoriteAdapter.setMovieFavorite()
    }

    companion object {
        fun newInstance() = MovieFavoriteFragment()
    }
}
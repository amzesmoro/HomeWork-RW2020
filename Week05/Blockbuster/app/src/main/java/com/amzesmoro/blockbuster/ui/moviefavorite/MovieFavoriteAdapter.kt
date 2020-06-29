package com.amzesmoro.blockbuster.ui.moviefavorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.Movie

class MovieFavoriteAdapter : RecyclerView.Adapter<MovieFavoriteViewHolder>() {

    private val movieFavorite = mutableListOf<Movie>()

    fun setMovieFavorite(listMovieFavorite: List<Movie>) {
        movieFavorite.clear()
        movieFavorite.addAll(listMovieFavorite)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_favorite, parent, false)
        return MovieFavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = movieFavorite.size

    override fun onBindViewHolder(holder: MovieFavoriteViewHolder, position: Int) {
        holder.bindMovieFavorite(movieFavorite[position])
    }

}


package com.amzesmoro.blockbuster.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.data.Movie

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()

    fun setMovies(listMovies: List<Movie>) {
        movies.clear()
        movies.addAll(listMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

}
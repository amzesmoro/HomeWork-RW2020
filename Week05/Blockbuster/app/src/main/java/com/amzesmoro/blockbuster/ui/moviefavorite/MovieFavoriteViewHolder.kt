package com.amzesmoro.blockbuster.ui.moviefavorite

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.blockbuster.model.Movie
import kotlinx.android.synthetic.main.item_movie_favorite.view.*

class MovieFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindMovieFavorite(movie: Movie) = with(itemView) {
        if (movie.title.length >= 25) {
            movieNameTv.text = String.format("%s...", movie.title.substring(0, 24))
        } else {
            movieNameTv.text = movie.title
        }
        movieRelaseDateTv.text = movie.releaseDate
        movieDurationTv.text = movie.movieDuration
        movieOriginalLanguageTv.text = movie.originalLanguage
        movieRatingTv.text = movie.rating
        posterImage.setImageResource(movie.poster)
    }
}
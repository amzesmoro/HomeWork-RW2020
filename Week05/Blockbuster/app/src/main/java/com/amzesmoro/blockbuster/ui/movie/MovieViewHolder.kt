package com.amzesmoro.blockbuster.ui.movie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.blockbuster.model.Movie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(movie: Movie, itemClicked: (Movie) -> Unit) {
        with(containerView) {
            if (movie.title.length > 12) {
                movieNameTv.text = String.format("%s...", movie.title.substring(0, 11))
            } else {
                movieNameTv.text = movie.title
            }
            posterImage.setImageResource(movie.poster)
            posterImage.setOnClickListener {
                itemClicked(movie)
            }
        }
    }
}
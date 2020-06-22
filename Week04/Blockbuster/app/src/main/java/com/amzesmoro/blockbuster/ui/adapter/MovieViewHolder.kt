package com.amzesmoro.blockbuster.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.blockbuster.data.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) {
        with(itemView) {
            movieNameTv.text = movie.title
            movie.poster?.let {
                Picasso.get()
                    .load(it)
                    .into(posterImage)
            }
        }
    }
}
package com.amzesmoro.blockbuster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie

        movieNameTv.text = movie.title
        movieRatingTv.text = movie.rating
        movieRelaseDateTv.text = movie.releaseDate
        movieGenreTv.text = movie.genre
        movieDurationTv.text = movie.movieDuration
        movieOriginalLanguageTv.text = movie.originalLanguage
        movieDescriptionTv.text = movie.summary
        movie.poster.let {
            Picasso.get().load(it).into(posterImage)
        }
        movie.backdropPoster.let {
            Picasso.get().load(it).into(backdropPosterImage)
        }
        /*movieShareBtn.setOnClickListener {
            val message = "${movieNameTv.text}.\nDescription is: ${movieDescriptionTv.text}"
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, message)
                type = "plain/text"
            }
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }*/
    }

}
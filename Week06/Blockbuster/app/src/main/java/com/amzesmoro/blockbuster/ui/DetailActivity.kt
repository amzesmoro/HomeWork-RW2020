package com.amzesmoro.blockbuster.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.Movie
import com.amzesmoro.blockbuster.model.MovieRepository
import com.amzesmoro.blockbuster.ui.DetailActivity.Companion.MOVIE_ID_KEY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

fun startMovieDetailActivity(from: Activity, movieId: Int) =
    from.startActivity(Intent(from, DetailActivity::class.java).apply {
        putExtra(MOVIE_ID_KEY, movieId)
    })
class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE_ID_KEY = "MOVIE_ID_KEY"
        const val MOVIE_KEY = 200
    }

    private val movieId by lazy { intent.getIntExtra(MOVIE_ID_KEY, MOVIE_KEY) }
    private val movieRepository by lazy { MovieRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = movieRepository.getMovieById(movieId)
        showMovieDetail(movie)
    }

    private fun showMovieDetail(movie: Movie) {
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

        movieShareBtn.setOnClickListener {
            val message = "${movieNameTv.text}.\nDescription is: ${movieDescriptionTv.text}"
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, message)
                type = "plain/text"
            }
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }
    }

}
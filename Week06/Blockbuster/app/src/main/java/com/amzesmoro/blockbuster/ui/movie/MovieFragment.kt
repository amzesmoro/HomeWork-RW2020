package com.amzesmoro.blockbuster.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.Movie
import com.amzesmoro.blockbuster.model.MovieRepository
import com.amzesmoro.blockbuster.ui.DetailActivity
import com.amzesmoro.blockbuster.ui.startMovieDetailActivity
import com.amzesmoro.blockbuster.utils.listMovies
import com.amzesmoro.blockbuster.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private val movieRepository by lazy { MovieRepository() }
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel = activity.let {
            ViewModelProviders.of(this).get(MovieViewModel::class.java)
        }
        movieRepository.storeMoviesIfNotEmpty(listMovies)
        initRecyclerView()
    }


    private fun initRecyclerView() {
        movieRv.setHasFixedSize(true)
        movieRv.layoutManager = GridLayoutManager(context, 2)
        val cardViewMovieAdapter = MovieAdapter(::movieClicked)
        movieRv.adapter = cardViewMovieAdapter

        movieViewModel.getMovies().observe(this, Observer {
            cardViewMovieAdapter.setMovies(listMovies)
        })
    }

    private fun movieClicked(movie: Movie) {
        activity?.let {
            startMovieDetailActivity(it, movie.id)
        }
    }

    companion object {
        fun newInstance() = MovieFragment()
    }
}
package com.amzesmoro.blockbuster.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.Movie
import com.amzesmoro.blockbuster.model.User
import com.amzesmoro.blockbuster.ui.DetailActivity
import com.amzesmoro.blockbuster.ui.login.MainActivity
import com.amzesmoro.blockbuster.utils.listMovies
import com.amzesmoro.blockbuster.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.item_movie.*

class MovieFragment : Fragment() {

    //private lateinit var user: User
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
        //username.text = user.username
        initRecyclerView()
    }

    private fun initRecyclerView() {
        movieRv.setHasFixedSize(true)
        movieRv.layoutManager = GridLayoutManager(context, 2)
        val cardViewMovieAdapter = MovieAdapter(::movieClicked)
        movieRv.adapter = cardViewMovieAdapter
        cardViewMovieAdapter.setMovies(listMovies)
        /*favoriteImgBtn.setOnClickListener {
            addMovieFavorite()
        }*/

    }

    private fun addMovieFavorite() {
        //
    }


    private fun movieClicked(movie: Movie) {
        Intent(activity, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_MOVIE, movie)
            startActivity(this)
        }
    }

    companion object {
        fun newInstance() = MovieFragment()
    }
}
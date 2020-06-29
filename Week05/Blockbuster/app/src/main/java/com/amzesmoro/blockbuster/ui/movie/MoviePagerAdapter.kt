package com.amzesmoro.blockbuster.ui.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.amzesmoro.blockbuster.ui.moviefavorite.MovieFavoriteFragment

class MoviePagerAdapter(fragmentManager: FragmentManager, behavior: Int)
    : FragmentStatePagerAdapter(fragmentManager, behavior) {

    private val tabTitle: List<String> = listOf("Movie", "Movie Favorite")

    override fun getItem(position: Int): Fragment = when(position) {
        0 -> MovieFragment()
        1 -> MovieFavoriteFragment()
        else -> MovieFragment()
    }

    override fun getCount(): Int = tabTitle.size

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitle[position]
    }
}
package com.amzesmoro.blockbuster.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.User
import com.amzesmoro.blockbuster.model.UserPreference
import com.amzesmoro.blockbuster.ui.movie.MovieActivity
import com.amzesmoro.blockbuster.ui.movie.MoviePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tabLayout
import kotlinx.android.synthetic.main.activity_main.viewPager
import kotlinx.android.synthetic.main.activity_movie.*

class MainActivity : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation = 0.0f
        val pagerAdapter = MoviePagerAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        userPreference = UserPreference(this)
        if (!userPreference.isUserLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        userPreference.setUser(user, false)
        startActivity(Intent(this, MainActivity::class.java))
        return super.onOptionsItemSelected(item)
    }

}
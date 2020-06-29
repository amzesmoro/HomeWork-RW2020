package com.amzesmoro.blockbuster.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.User
import com.amzesmoro.blockbuster.model.UserPreference
import com.amzesmoro.blockbuster.ui.login.MainActivity
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        supportActionBar?.elevation = 0.0f
        val pagerAdapter = MoviePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
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
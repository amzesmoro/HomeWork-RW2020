package com.amzesmoro.blockbuster.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.User
import com.amzesmoro.blockbuster.model.UserPreference
import com.amzesmoro.blockbuster.ui.login.LoginActivity
import com.amzesmoro.blockbuster.ui.movie.MoviePagerAdapter
import kotlinx.android.synthetic.main.activity_main.tabLayout
import kotlinx.android.synthetic.main.activity_main.viewPager


class MainActivity : AppCompatActivity() {

    private val userPreference by lazy { UserPreference() }
    private val user by lazy { User() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation = 0.0f
        val pagerAdapter = MoviePagerAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.logoutMenu -> {
                userPreference.setUserLoggedIn(user, false)
                navigateToLoginScreen()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateToLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}


package com.amzesmoro.blockbuster.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.User
import com.amzesmoro.blockbuster.model.UserPreference
import com.amzesmoro.blockbuster.ui.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RESULT = "extra_result"
    }

    private lateinit var userPreference: UserPreference
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userPreference = UserPreference(this)
        user = userPreference.getUser()
        loginButton.setOnClickListener {
            checkForm(user)
        }
    }

    private fun checkForm(user: User) {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        when {
            username.isEmpty() -> usernameEditText.error = "Username cannot be blank."
            password.isEmpty() -> passwordEditText.error = "Password cannot be blank."
            username.length <= 1 -> usernameEditText.error = "Username cannot be only one letter."
            password.length < 4 -> passwordEditText.error = "Password has to be at least 4 letters."
            else -> {
                saveUser(username, password)
                finish()
                Intent(this, MovieActivity::class.java).apply {
                    putExtra(EXTRA_RESULT, user)
                    startActivity(this)
                }
            }
        }
    }

    private fun saveUser(username: String, password: String) {
        val userPreference = UserPreference(this)
        user.username = username
        user.password = password
        userPreference.setUser(user, true)
    }

}
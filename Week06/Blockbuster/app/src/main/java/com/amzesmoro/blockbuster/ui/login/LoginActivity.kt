package com.amzesmoro.blockbuster.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amzesmoro.blockbuster.R
import com.amzesmoro.blockbuster.model.User
import com.amzesmoro.blockbuster.model.UserPreference
import com.amzesmoro.blockbuster.ui.MainActivity
import com.amzesmoro.blockbuster.utils.LoginValidator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginValidator by lazy { LoginValidator() }
    private val userPreference by lazy { UserPreference() }
    private val user by lazy { User() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        checkIfUserLoggedIn()
        loginButton.setOnClickListener { checkCredentials() }
    }

    private fun checkIfUserLoggedIn() {
        if (userPreference.isUserLoggedIn()) {
            navigateToMovieScreen()
        }
    }

    private fun checkCredentials() {
        loginValidator.setCredentials(
            usernameInputEditText.text.toString(),
            passwordInputEditText.text.toString()
        )

        checkUsername()
        checkPassword()

        if (loginValidator.areCredentialsValid()) {
            userPreference.setUserLoggedIn(user,true)
            navigateToMovieScreen()
        }
    }

    private fun checkUsername() = if (!loginValidator.isUsernameValid()) {
        usernameTextInputLayout.error = getString(R.string.username_text_error)
    } else {
        usernameTextInputLayout.error = null
    }

    private fun checkPassword() {
        if (!loginValidator.isPasswordValid()) {
            passwordTextInputLayout.error = getString(R.string.password_text_error)
        } else {
            passwordTextInputLayout.error = null
        }
    }

    private fun navigateToMovieScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}

package com.amzesmoro.blockbuster.utils

class LoginValidator {
    private lateinit var username: String
    private lateinit var password: String

    fun setCredentials(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun isUsernameValid() = username.length > 2

    fun isPasswordValid() = password.length >= 4

    fun areCredentialsValid() = isUsernameValid() && isPasswordValid()
}
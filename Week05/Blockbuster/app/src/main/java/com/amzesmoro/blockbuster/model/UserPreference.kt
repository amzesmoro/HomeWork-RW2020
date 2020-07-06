package com.amzesmoro.blockbuster.model

import android.content.Context
import com.amzesmoro.blockbuster.app.MovieApplication

class SharedPreference {

    companion object {
        private const val USER_PREFS = "USER_PREFS"
        private const val USERNAME = "USERNAME"
        private const val PASSWORD = "PASSWORD"
        private const val KEY_USER_LOGGED = "KEY_USER_LOGGED"
    }

    private val context = MovieApplication.getAppContext()

    private val sharedPrefs = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)

//    fun setUserLoggedIn(user: User, isLoggedIn: Boolean) {
//        sharedPrefs.edit().run {
//            putString(USERNAME, user.username)
//            putString(PASSWORD, user.password)
//            putBoolean(KEY_USER_LOGGED, isLoggedIn    )
//        }.apply()
//    }

    fun setUserLoggedIn(isLoggedIn: Boolean) {
        sharedPrefs.edit().putBoolean(KEY_USER_LOGGED, isLoggedIn).apply()
    }

    fun getUserLoggedIn(user: User) {
        user.username = sharedPrefs.getString(USERNAME, "")
        user.password = sharedPrefs.getString(PASSWORD, "")
    }

    fun isUserLoggedIn() = sharedPrefs.getBoolean(KEY_USER_LOGGED, false)

}
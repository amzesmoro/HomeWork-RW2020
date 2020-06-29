package com.amzesmoro.blockbuster.model

import android.content.Context

class UserPreference(context: Context) {

    companion object {
        private const val USER_PREFS = "USER_PREFS"
        private const val USERNAME = "USERNAME"
        private const val PASSWORD = "PASSWORD"
        private const val KEY_USER_LOGGED = "KEY_USER_LOGGED"
    }

    private val sharedPrefs = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)

    fun setUser(user: User, logged: Boolean) {
        val editor = sharedPrefs.edit()
        editor.putString(USERNAME, user.username)
        editor.putString(PASSWORD, user.password)
        editor.putBoolean(KEY_USER_LOGGED, logged)
        editor.apply()
    }

    fun getUser(): User {
        val user = User()
        user.username = sharedPrefs.getString(USERNAME, "")
        user.password = sharedPrefs.getString(PASSWORD, "")
        return user
    }

    fun isUserLoggedIn(): Boolean {
        return sharedPrefs.getBoolean(KEY_USER_LOGGED, false)
    }
}
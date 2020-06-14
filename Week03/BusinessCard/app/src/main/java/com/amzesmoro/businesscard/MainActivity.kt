package com.amzesmoro.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_menu -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
                return  true
            }
            R.id.languange_menu -> {
                val changeLanguageIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(changeLanguageIntent)
                return true
            }
            R.id.info_menu -> {
                showInfo()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showInfo() {
        val dialogTitile = getString(R.string.info_title)
        val dialogMessage = getString(R.string.info_message)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitile)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }
}
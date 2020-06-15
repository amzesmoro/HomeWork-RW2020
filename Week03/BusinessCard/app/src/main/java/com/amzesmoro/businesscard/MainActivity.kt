package com.amzesmoro.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listPresident = ArrayList<President>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_president.setHasFixedSize(true)
        listPresident.addAll(getListPresident())
        rv_president.layoutManager = LinearLayoutManager(this)
        val cardViewPresidentAdapter = CardViewPresidentAdapter(listPresident)
        rv_president.adapter = cardViewPresidentAdapter
    }

    private fun getListPresident(): ArrayList<President> {
        val presidentSequence = resources.getStringArray(R.array.president_sequence)
        val presidentName = resources.getStringArray(R.array.president_name)
        val presidentPeriod = resources.getStringArray(R.array.president_period)
        val presidentToo = resources.getStringArray(R.array.president_too)
        val presidentImage = resources.obtainTypedArray(R.array.president_image)

        val list = ArrayList<President>()
        for (position in presidentSequence.indices) {
            val president = President(
                presidentSequence[position],
                presidentName[position],
                presidentPeriod[position],
                presidentToo[position],
                presidentImage.getResourceId(position, 0)
            )
            list.add(president)
        }
        return list
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
        val dialogTitle = getString(R.string.info_title)
        val dialogMessage = getString(R.string.info_message)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }
}
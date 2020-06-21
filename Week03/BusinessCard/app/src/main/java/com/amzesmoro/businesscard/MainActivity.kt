package com.amzesmoro.businesscard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.amzesmoro.businesscard.adapter.CardViewPresidentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presidentRv.setHasFixedSize(true)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        presidentRv.layoutManager = LinearLayoutManager(this)
        val cardViewPresidentAdapter = CardViewPresidentAdapter(this)
        presidentRv.adapter = cardViewPresidentAdapter
        //get all data
        val dataPresident = cardViewPresidentAdapter.getDataPresident()
        cardViewPresidentAdapter.setDataPresident(dataPresident)
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
                return true
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

        AlertDialog.Builder(this).run {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            create().show()
        }
    }
}
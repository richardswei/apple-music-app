package com.example.applemusicapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity


class AlbumsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Quarkify";
        setContentView(R.layout.albums_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.actions, menu)
        val numbers: Array<String> = arrayOf("5", "10", "25", "50")

//        val toggle: ToggleButton = findViewById(R.id.allow_explicit)
//        toggle.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                toggleExplicit()
//                // The toggle is enabled
//            } else {
//                toggleExplicit()
//                // The toggle is disabled
//            }
//        }
        // access the spinner
//        val spinner = findViewById<Spinner>(R.id.spinner)
//        if (spinner != null) {
//            val adapter = ArrayAdapter(this,
//                android.R.layout.simple_spinner_item, numbers)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener = object :
//                AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>,
//                                            view: View, position: Int, id: Long) {
//                    //  Something happens here
//                }
//                override fun onNothingSelected(parent: AdapterView<*>) {
//                    // Something happens here
//                }
//            }
//        }
        return true;
    }

// the menu options aren't working for me right now
// plan was to have the options when toggled, call the retrieveAlbums function with the new params
    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle item selection
        return when (item.itemId) {
            R.id.allow_explicit -> {
                toggleExplicit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleExplicit() {
        println("Toggling Explicit")
    }

}

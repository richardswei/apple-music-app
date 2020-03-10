package com.example.applemusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.albums_main.*

class AlbumsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.albums_main)
        val data = DataBuilder.buildFakeData()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rvAlbumList.layoutManager = layoutManager
        rvAlbumList.adapter = AlbumAdapter(this, data)
    }
}

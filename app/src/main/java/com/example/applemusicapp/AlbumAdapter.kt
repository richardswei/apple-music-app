package com.example.applemusicapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class AlbumAdapter(private val context: AlbumsActivity, private val albumList: ArrayList<String>) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
//

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//      each item in the list is a view holder
//        inflating means build
//        returns a view holder that acts as a template for each one
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // onBind runs once for each item
        holder.AlbumName.text = albumList[position]
        //  use picasso/glide for setting the image in the viewHolder
        holder.itemView.setOnClickListener {
            Toast.makeText(context, albumList[position], Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //    adapter is what holds the info
        //    create a new val for each element in the list item
        val AlbumName: TextView = view.albumName
    }
}
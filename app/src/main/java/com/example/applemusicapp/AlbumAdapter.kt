package com.example.applemusicapp

import Feed
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusicapp.data.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class AlbumAdapter(private val context: AlbumsActivity, private val albumResults: List<Album>) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//      each item in the list is a view holder
//        inflating means build
//        returns a view holder that acts as a template for each one
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return albumResults.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // onBind runs once for each item
        holder.albumName.text = albumResults[position].name
        holder.artistName.text = albumResults[position].artistName

        Picasso.get().load(albumResults[position].artworkUrl100).into(holder.imageView);

        //  use picasso/glide for setting the image in the viewHolder
        holder.itemView.setOnClickListener {
            Toast.makeText(context, albumResults[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //    adapter is what holds the info
        //    create a new val for each element in the list item
        val albumName: TextView = view.albumName
        val artistName: TextView = view.artistName
        val imageView: ImageView = view.albumArtworkView

    }
}
package com.example.applemusicapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusicapp.data.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class AlbumAdapter(private val context: Context, private val albumResults: List<Album>) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        each item in the list is a view holder
//        inflating means build
//        returns a view holder that acts as a template for each one
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return albumResults.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // onBind runs once for each item
        val currAlbum = albumResults[position]
        holder.albumName.text = currAlbum.name
        holder.artistName.text = currAlbum.artistName
        //  use picasso/glide for setting the image in the viewHolder
        Picasso.get().load(currAlbum.artworkUrl100).into(holder.imageView)
        // get genres
        val genres = ArrayList<String>()
        for ((k, v) in currAlbum.genres) {
            genres.add(v)
        }
        holder.itemView.setOnClickListener {view ->
            val bundle = bundleOf(
                "artistName" to currAlbum.artistName,
                "albumName" to currAlbum.name,
                "id" to currAlbum.id,
                "releaseDate" to currAlbum.releaseDate,
                "kind" to currAlbum.kind,
                "copyright" to currAlbum.copyright,
                "artistId" to currAlbum.artistId,
                "contentAdvisoryRating" to currAlbum.contentAdvisoryRating,
                "artistUrl" to currAlbum.artistUrl,
                "genres" to genres.joinToString(", "),
                "artworkUrl100" to currAlbum.artworkUrl100
            )
            view.findNavController().navigate(R.id.action_ListFragment_to_DetailsFragment, bundle)
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
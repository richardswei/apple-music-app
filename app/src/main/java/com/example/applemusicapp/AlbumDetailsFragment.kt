package com.example.applemusicapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.applemusicapp.data.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_details_fragment.*


class AlbumDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.album_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val album = arguments?.getSerializable("album") as Album

        // get genres
        val genresArray = ArrayList<String>()
        for ((k, v) in album.genres) {
            genresArray.add(v)
        }
//        apparently, if you import the entire frag you don't need to find any of the views by ID (unless custom name)
        Picasso.get().load(album.artworkUrl100).into(albumArtwork)
        albumName.text = album.name
        artistButton.text = album.artistName
        releaseDate.text = getString(R.string.releaseDate, album.releaseDate)
        explicit.text = album.contentAdvisoryRating
        genres.text = getString(R.string.genres, genresArray.joinToString(", "))
        val copyrightText = album.copyright
        copyright.text = copyrightText?.replace(";", ";\n") // have multiple labels separated by semicolon. insert newlines here

//        click on artist to return to the rv view
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_DetailsFragment_to_ListFragment/*, bundle*/)
        }

//        click on artist to go to the apple music page
        artistButton.setOnClickListener {
            val uri = Uri.parse(album.artistUrl) // missing 'http://' will cause crashed
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

}
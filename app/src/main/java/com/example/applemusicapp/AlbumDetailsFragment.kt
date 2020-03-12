package com.example.applemusicapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
//        val artwork = view.findViewById<ImageView>(R.id.albumArtwork)
//        val album = view.findViewById<TextView>(R.id.albumName)
//        val artist = view.findViewById<TextView>(R.id.artistName)
//        val releaseDate = view.findViewById<TextView>(R.id.releaseDate)
//        apparently, if you import the entire frag you don't need to find any of the views by ID (unless custom name)
        Picasso.get().load(arguments?.getString("artworkUrl100")).into(albumArtwork)
        albumName.text = arguments?.getString("albumName")
        artistButton.text = arguments?.getString("artistName")
        releaseDate.text = getString(R.string.releaseDate, arguments?.getString("releaseDate"))
        explicit.text = arguments?.getString("contentAdvisoryRating")
        genres.text = getString(R.string.genres, arguments?.getString("genres"))
        val copyrightText = arguments?.getString("copyright")
        copyright.text = copyrightText?.replace(";", ";\n")

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            findNavController().navigate(R.id.action_DetailsFragment_to_ListFragment/*, bundle*/)
        }
    }

}
package com.example.applemusicapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusicapp.data.Album
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.album_list_fragment.*

class AlbumListFragment : Fragment() {
//    have a rxJava disposable, this will be the data from the rss
    private var disposable: Disposable? = null
//    create the rss req interface obj
    private val appleServe by lazy {
        AppleMusicService.create()
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.album_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        get and send the albums to the adapter
        retrieveTopAlbums(25, true)
    }

    private fun retrieveTopAlbums(numToGet: Int, explicit: Boolean) {
        val typeAllowed = if (explicit) "explicit" else "non-explicit"
        disposable = appleServe.getData(numToGet, typeAllowed)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data -> handleResponse(data.feed.albums) },
                { error -> Toast.makeText(this.context, error.message, Toast.LENGTH_LONG).show() }
            )
    }
    private fun handleResponse(albumList: List<Album>) {
        //Set the adapter//
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.requireContext())
        rvAlbumList.layoutManager = layoutManager
        rvAlbumList.adapter = AlbumAdapter(this.requireContext(), albumList)
    }

}
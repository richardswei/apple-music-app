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
    private var disposable: Disposable? = null
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
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.requireContext())
        rvAlbumList.layoutManager = layoutManager
        retrieveTopAlbums()
    }

    private fun retrieveTopAlbums() {
        disposable = appleServe.getData(20, "non-explicit")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {  data -> handleResponse(data.feed.albums) },
                { error -> Toast.makeText(this.context, error.message, Toast.LENGTH_LONG).show() }
            )
    }
    private fun handleResponse(albumList: List<Album>) {
        println(albumList)
        //Set the adapter//

        rvAlbumList.adapter = AlbumAdapter(this.requireContext(), albumList)
    }

}
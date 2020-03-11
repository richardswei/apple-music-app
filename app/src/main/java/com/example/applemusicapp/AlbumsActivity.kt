package com.example.applemusicapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusicapp.data.Album
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.albums_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    private val appleServe by lazy {
        AppleMusicService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.albums_main)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rvAlbumList.layoutManager = layoutManager
        retrieveTopAlbums()
//        val albumList: ArrayList<Album> = ArrayList()
//        val adapter = AlbumAdapter(this, albumList)
//        rvAlbumList.adapter = adapter

//        val baseUrl = "https://rss.itunes.apple.com/api/v1/"
//        val requestInterface = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//        val albumsData = requestInterface.create(AppleMusicService::class.java)
//        var response = albumsData.getData()
//        //Displaying List//
//        response.observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                    data -> handleResponse(data)
//            }, {
//                    throwable -> Log.e("TAG", "Throwable " + throwable.localizedMessage)
//            })
    }

    private fun retrieveTopAlbums() {
        disposable = appleServe.getData(20, "non-explicit")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {  data -> handleResponse(data.feed.albums) },
                { error -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show() }
            )
    }
    private fun handleResponse(albumList: List<Album>) {
        println(albumList)
        //Set the adapter//
        rvAlbumList.adapter = AlbumAdapter(this, albumList)
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}

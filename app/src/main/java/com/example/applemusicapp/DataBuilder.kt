package com.example.applemusicapp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class DataBuilder() {
    private fun loadData() {

    }



    /*
    this class should get data via OKHTTP
    it should also be able to parse the data
    view should call one of these actions
    * */

//        private val client = OkHttpClient()

//        fun getNumberOfAlbums(numberToGet : Int) {
//            val request = Request.Builder()
//                .url("https://rss.itunes.apple.com/api/v1/us/apple-music/top-albums/all/$numberToGet/explicit.json")
//                .build()
//            client.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    e.printStackTrace()
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    println("getResponse")
//
//                    val albumList: ArrayList<Album> = ArrayList()
//                    response.use {
//                        if (!response.isSuccessful) throw IOException("Unexpected code $response")
//                        val obj = JSONObject(response.body()?.string().toString())
//                        val feed = obj.getJSONObject("feed")
//                        val results = feed.getJSONArray("results")
//                        for (i in 0 until results.length()) {
//                            val currResult : JSONObject = results[i] as JSONObject
//                            val albumName = currResult.getString("name")
//                            val artistName = currResult.getString("artistName")
//                            val artistUrl = currResult.getString("artistUrl")
//                            val artworkUrl = currResult.getString("artworkUrl100")
//                            val releaseDate = currResult.getString("releaseDate")
//                            val genres : ArrayList<String> = ArrayList()
//                            val genreJsonList = currResult.getJSONArray("genres")
//                            for (g in 0 until genreJsonList.length()) {
//                                val currGenreObj : JSONObject = genreJsonList[g] as JSONObject
//                                genres.add(currGenreObj.getString("name"))
//                            }
//                            val currAlbum = Album(albumName, artistName, artistUrl, artworkUrl, genres, releaseDate)
//                            albumList.add(currAlbum)
//                        }
//                        Handler(Looper.getMainLooper()).post {
//                            //code that runs in main
//                            println(albumList)
//                            val adapter = AlbumAdapter(AlbumsActivity(), albumList)
//                            currentAdapter
//                        }
//
//
//
//                    }
//                }
//            })
//        }

        fun buildFakeData() : ArrayList<String> {
            val wordList: ArrayList<String> = ArrayList()
            // replace this with data builder call
            for (x in 1..30) wordList.add("word $x")
            return wordList
        }
}
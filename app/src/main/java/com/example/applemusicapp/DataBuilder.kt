package com.example.applemusicapp

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class DataBuilder () {
    /*
    this class should get data via OKHTTP
    it should also be able to parse the data
    view should call one of these actions
    * */

    companion object {
        private val client = OkHttpClient()

        private fun getNumberOfAlbums(numberToGet : Int) {
            val request = Request.Builder()
                .url("https://rss.itunes.apple.com/api/v1/us/apple-music/top-albums/all/10/explicit.json")
                .build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")
                        val obj = JSONObject(response.body()?.string().toString())
                        val feed = obj.getJSONObject("feed")
                        val title = feed.getString("title")
                        println(title)
                    }
                }
            })
        }

        fun buildFakeData() : ArrayList<String> {
            val wordList: ArrayList<String> = ArrayList()
            // replace this with data builder call
            for (x in 1..30) wordList.add("word $x")
            return wordList
        }
    }

}
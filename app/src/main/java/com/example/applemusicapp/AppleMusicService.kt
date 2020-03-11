package com.example.applemusicapp

import com.example.applemusicapp.data.RssResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface AppleMusicService {
    @GET("us/apple-music/top-albums/all/{num}/{explicit}.json")
    fun getData(@Path("num") num : Int,
                @Path("explicit") explicit : String // can be either 'explicit' or 'non-explicit'
                ) : Observable<RssResponse>


    companion object {
        fun create(): AppleMusicService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://rss.itunes.apple.com/api/v1/")
                .build()

            return retrofit.create(AppleMusicService::class.java)
        }
    }
}
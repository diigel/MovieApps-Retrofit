package com.digel.movieapplication.network

import android.annotation.SuppressLint
import android.content.Context
import com.digel.movieapplication.MovieApplication
import com.digel.movieapplication.R

@SuppressLint("StaticFieldLeak")
object EndPoint {

    private val context: Context = MovieApplication.getApplicationContext().applicationContext
    val baseUrl = context.resources.getString(R.string.base_url)
    val imgUrl = context.resources.getString(R.string.img_url)
    val apiKey = context.resources.getString(R.string.api_key)

}
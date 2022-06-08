package com.digel.movieapplication

import android.app.Application
import android.content.Context

class MovieApplication : Application() {

    companion object {
        lateinit var instance : MovieApplication
        fun getApplicationContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}
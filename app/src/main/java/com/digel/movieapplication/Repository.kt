package com.digel.movieapplication

import retrofit2.Call

interface Repository {
    fun getMovieList(): Call<MovieListResponse>
}
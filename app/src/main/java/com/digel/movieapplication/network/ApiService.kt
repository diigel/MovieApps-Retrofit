package com.digel.movieapplication.network

import com.digel.movieapplication.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovieList(
        @Query("api_key") apiKey : String = EndPoint.apiKey,
        @Query("language") language : String = "en-US",
        @Query("page") page : Int = 1,
    ) : Call<MovieListResponse>
}
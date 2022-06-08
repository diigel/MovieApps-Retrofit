package com.digel.movieapplication

import com.digel.movieapplication.network.Network
import retrofit2.Call

class RepositoryImpl: Repository {
    override fun getMovieList(): Call<MovieListResponse> {
        return Network.getApiService().getMovieList()
    }

}
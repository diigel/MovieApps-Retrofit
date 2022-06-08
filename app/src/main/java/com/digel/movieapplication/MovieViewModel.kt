package com.digel.movieapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    val movieList: MutableLiveData<MovieListResponse> = MutableLiveData()
    val repository = RepositoryImpl()

    fun getMovieList() : LiveData<MovieListResponse> {
        repository.getMovieList().enqueue(object : Callback<MovieListResponse>{
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>
            ) {
                if(response.isSuccessful) {
                    movieList.value = response.body()
                } else {
                    movieList.value = null
                }
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
               t.printStackTrace()
            }

        })

        return movieList
    }

}
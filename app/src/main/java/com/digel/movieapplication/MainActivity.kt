package com.digel.movieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.digel.movieapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieAdapter by lazy {
        MovieAdapter()
    }

    private val viewModel : MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            rvMovie.layoutManager = LinearLayoutManager(this@MainActivity)
            rvMovie.adapter = movieAdapter

            viewModel.getMovieList()
            getData()
        }
    }

    fun getData() {
        viewModel.movieList.observe(this, { movieList ->
            movieList.let {
                movieAdapter.addMovieList(it.results ?: emptyList())
            }
        })
    }
}
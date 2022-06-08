package com.digel.movieapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digel.movieapplication.databinding.ItemMovieBinding
import com.digel.movieapplication.network.EndPoint

class MovieAdapter :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    val movieList: MutableList<MovieListResponse.Result> = mutableListOf()

    fun addMovieList(list: List<MovieListResponse.Result>){
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])

    }

    override fun getItemCount(): Int {
       return movieList.size
    }

    inner class MovieViewHolder(private  val binding : ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movieData: MovieListResponse.Result) = binding.run {
            txtTitle.text = movieData.title
            txtDesc.text = movieData.overview

            Glide.with(root.context)
                .load(EndPoint.imgUrl+movieData.posterPath)
                .into(imgMovie)
        }

    }
}
package com.example.appthemovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appthemovies.databinding.HorizontalMovieItemBinding
import com.example.appthemovies.models.Result



class TheMovieAdapter() : ListAdapter<Result, TheMovieAdapter.ViewHolder>(DiffCallback()) {

    private var fullList = mutableListOf<Result>()

    inner class ViewHolder(
        private val binding: HorizontalMovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        fun bind(movie: Result) {
            binding.movieTitle.text = movie.title
            binding.releaseDate.text = movie.release_date
            Glide.with(itemView).load(IMAGE_BASE + movie.poster_path).into(binding.moviePoster)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HorizontalMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        return holder.bind(currentItem)
    }

    fun update(it: List<Result>) {
        fullList = it.toMutableList()
        submitList(fullList)
    }


    class DiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Result, newItem: Result) =
            oldItem == newItem
    }
}














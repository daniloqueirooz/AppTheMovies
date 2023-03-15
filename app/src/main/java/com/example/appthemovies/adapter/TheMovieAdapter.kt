package com.example.appthemovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appthemovies.R
import com.example.appthemovies.const.Layout.VERTICAL
import com.example.appthemovies.model.MovieModel


class TheMovieAdapter(
    private val layout: Int = 1,
    val onItemClick: (MovieModel) -> Unit
) : RecyclerView.Adapter<TheMovieAdapter.TheMovieHolder>() {

    private var dataset = mutableListOf<MovieModel>()

    fun setMovieList(lives: List<MovieModel>) {
        this.dataset = lives.toMutableList()
        notifyDataSetChanged()

    }

    class TheMovieHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.findViewById(R.id.image_movie)
        val textView1: TextView = view.findViewById(R.id.Avaliados)
        val TextView2: TextView = view.findViewById(R.id.Name)

        companion object {
            const val BASE_URL = "https://api.themoviedb.org/3/"
        }


        fun item(movie: MovieModel) {
            imageView.load(BASE_URL + movie.post)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheMovieHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_movie_item, parent, false)

        return TheMovieHolder(layout)
    }


    override fun onBindViewHolder(holder: TheMovieHolder, position: Int) {
        val item = dataset[position]
        holder.item(dataset[position])

        holder.itemView.apply {
            holder.item(dataset[position])

            if (item.id == 1) {
                if (layout == VERTICAL) {
                    holder.textView1.text = resources.getString(R.string.titulo_filmes_embreve)

                } else {
                    holder.textView1.text =
                        resources.getString(R.string.titulo_filmes_tendencia)
                }
            }
        }
        holder.TextView2.text = item.nome
        holder.imageView.setImageResource(item.imageResourceId)

        holder.itemView.setOnClickListener {
            onItemClick(item)

        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}












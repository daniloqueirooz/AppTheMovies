package com.example.appthemovies.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appthemovies.R
import com.example.appthemovies.const.Layout
import com.example.appthemovies.const.Layout.VERTICAL
import com.example.appthemovies.data.DataSource

class TheMovieAdapter(

    private val layout: Int

) : RecyclerView.Adapter<TheMovieAdapter.TheMovieHolder>() {

    private val dataset = DataSource.filmes

    class TheMovieHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_movie)
        val textView1: TextView = view.findViewById(R.id.Avaliados)
        val TextView2: TextView = view.findViewById(R.id.Name)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheMovieHolder {
        val adapterLayout = when (layout) {
            Layout.HORIZONTAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.horizontal_movie_item, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.horizontal_movie_item, parent, false)
            }
        }
        return TheMovieHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: TheMovieHolder, position: Int) {
        val item = dataset[position]
        holder.itemView.apply {

            if (item.id == 1) {
                if (layout == VERTICAL) {
                    holder.textView1.text = resources.getString(R.string.titulo_filmes_embreve)

                } else {
                    holder.textView1.text = resources.getString(R.string.titulo_filmes_tendencia)

                }
            }
        }
        holder.TextView2.text = item.nome
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size

}






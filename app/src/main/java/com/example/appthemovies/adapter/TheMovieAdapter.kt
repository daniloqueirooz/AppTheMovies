package com.example.appthemovies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.appthemovies.R
import com.example.appthemovies.const.Layout
import com.example.appthemovies.data.DataSource

abstract class TheMovieAdapter(
    private val context: Context?,
    private val layout: Int

) : RecyclerView.Adapter<TheMovieAdapter.TheMovieHolder>() {

    private val dataset = DataSource.filmes

    class TheMovieHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.panteraNegra)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheMovieHolder {
        val adapterLayout = when (layout) {
            Layout.VERTICAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_list1, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_list1, parent, false)
            }
        }
        return TheMovieHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TheMovieHolder, position: Int) {
        val item = dataset[position]

        holder.imageView.setImageResource(item.imageResource)
    }

    override fun getItemCount() = dataset.size
}





package com.example.appthemovies.adapter


import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.appthemovies.HomeFragmentDirections
import com.example.appthemovies.R
import com.example.appthemovies.const.Layout
import com.example.appthemovies.const.Layout.VERTICAL
import com.example.appthemovies.data.DataSource


class TheMovieAdapter(

    private val layout: Int

) : RecyclerView.Adapter<TheMovieAdapter.TheMovieHolder>() {

    private val dataset = DataSource.filmes

    class TheMovieHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById<ImageView>(R.id.image_movie)
        val textView1: TextView = view.findViewById(R.id.Avaliados)
        val TextView2: TextView = view.findViewById(R.id.Name)
    }

    override fun getItemCount(): Int {
        return dataset.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheMovieHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_movie_item, parent, false)
        return TheMovieHolder(layout)
    }


    override fun onBindViewHolder(holder: TheMovieHolder, position: Int) {
        val item = dataset[position]

        holder.itemView.apply {

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
       // val action =
           // HomeFragmentDirections.actionHomeFragmentToMovieDetails(details = holder.imageView.toString())
       // holder.view.findNavController().navigate(action)
    }

}







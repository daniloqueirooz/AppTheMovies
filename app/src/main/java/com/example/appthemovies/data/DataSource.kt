package com.example.appthemovies.data

import com.example.appthemovies.R
import com.example.appthemovies.model.Movie

object DataSource {

    val filmes: List<Movie> = listOf(
        Movie(
            R.drawable.panteranegra,
            name = "Pantera Negra",
            auhtor = "Mavel Studios",
        )
    )
}


package com.example.appthemovies.data

import com.example.appthemovies.R
import com.example.appthemovies.model.Movie

object DataSource {

    val filmes: List<Movie> = listOf(
        Movie(
            R.drawable.panteranegra,
            nome = "Pantera Negra",
            auhtor = "Mavel Studios",
        ),
        Movie(
            R.drawable.panteranegra,
            nome = "Guerra Infinita",
            auhtor = "Mavel Studios",
        ),
        Movie(
            R.drawable.panteranegra,
            nome = "Adão Negro",
            auhtor = "Mavel Studios",
        )
    )
}

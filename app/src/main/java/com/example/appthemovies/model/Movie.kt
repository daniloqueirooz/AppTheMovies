package com.example.appthemovies.model

import androidx.annotation.DrawableRes

data class Movie(
    @DrawableRes val imageResourceId: Int,
    val Exibicao: String? = null,
    val Avaliados: String? = null,
)
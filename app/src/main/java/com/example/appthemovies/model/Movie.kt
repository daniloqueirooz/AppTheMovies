package com.example.appthemovies.model

import androidx.annotation.DrawableRes

data class Movie(
    @DrawableRes val imageResource: Int,
    val name: String,
    val auhtor: String?,

    )
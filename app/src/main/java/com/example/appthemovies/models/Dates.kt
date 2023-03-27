package com.example.appthemovies.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Dates(
    val maximum: String,
    val minimum: String
) : Parcelable
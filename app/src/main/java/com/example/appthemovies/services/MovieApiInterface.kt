package com.example.appthemovies.services

import com.example.appthemovies.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=7bb7deb6fa5b0dca787d42cd38735f33")
    fun getMovieList(): Call<MovieResponse>
}
package com.example.appthemovies.services

import com.example.appthemovies.models.MovieNowPlayingModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org"

interface MovieApiInterface {

    @GET("/3/movie/now_playing?api_key=7bb7deb6fa5b0dca787d42cd38735f33")
    fun getMovieNowPlayingList(): Call<MovieNowPlayingModel>

    //https://api.themoviedb.org/3/movie/{372058}?api_key=<<api_key>>&language=en-US
    //como passar um parametro na url pelo retrofit

    companion object {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun create(): MovieApiInterface {
            return retrofit.create(MovieApiInterface::class.java)
        }
    }
}
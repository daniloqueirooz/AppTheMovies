package com.example.appthemovies.network


import com.example.appthemovies.model.MovieModel
import com.example.appthemovies.utils.Constants.API_KEY
import com.example.appthemovies.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface MoviesApiService {
    @GET(API_KEY)
    suspend fun getPopular(): List<MovieModel>

}

object MovieApi {
    val retrofitService: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)


    }

    fun getInstance(): MoviesApiService {
        return retrofitService

    }


}
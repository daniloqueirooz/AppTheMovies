package com.example.appthemovies.services


import com.example.appthemovies.models.Movie
import com.example.appthemovies.models.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/* interface MovieApiService {

    companion object MovieApiService {
        private const val BASE_URL = "https://api.themoviedb.org"
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        }
    }

*/

interface MovieApiService {
    @GET("/3/movie/popular?api_key=7bb7deb6fa5b0dca787d42cd38735f33")
    fun getMovieList(): List<Movie>?
}

private const val BASE_URL = "https://api.themoviedb.org"

private var retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object MovieApi {
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}




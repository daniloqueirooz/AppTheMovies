package com.example.appthemovies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appthemovies.models.MovieNowPlayingModel
import com.example.appthemovies.services.MovieApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel(private val apiInterface: MovieApiInterface) : ViewModel() {

    private val _getMovies = MutableLiveData<MovieNowPlayingModel>()
    val getMovies: LiveData<MovieNowPlayingModel>
        get() = _getMovies

    val errorMessage = MutableLiveData<String>()


    fun getMovieData() {

        apiInterface.getMovieNowPlayingList().enqueue(object : Callback<MovieNowPlayingModel> {

            override fun onFailure(call: Call<MovieNowPlayingModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

            override fun onResponse(call: Call<MovieNowPlayingModel>, response: Response<MovieNowPlayingModel>) {
                _getMovies.postValue(response.body())
            }

        })


    }

}



package com.example.appthemovies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appthemovies.models.Movie
import com.example.appthemovies.services.MovieApi
import com.example.appthemovies.services.MovieApiInterface
import com.example.appthemovies.services.MovieApiService
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }

class HomeFragmentViewModel : ViewModel() {

    private val _status = MutableLiveData<MovieApiStatus>()

    val status: LiveData<MovieApiStatus> = _status

    private val _getMovies = MutableLiveData<List<Movie>>()

    val getMovies: LiveData<List<Movie>> = _getMovies

    init {
        initOne()
    }

    private fun initOne() = viewModelScope.launch {
        getMovieStatus()

    }

    private fun getMovieStatus() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
        }
        try {
            _getMovies.value = MovieApi.retrofitService.getMovieList()
            _status.value = MovieApiStatus.DONE
        } catch (e: Exception) {
            _status.value = MovieApiStatus.ERROR
            _getMovies.value = listOf()
        }

    }

}



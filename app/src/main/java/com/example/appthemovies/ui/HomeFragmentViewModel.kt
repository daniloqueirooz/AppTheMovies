package com.example.appthemovies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appthemovies.model.MovieModel
import com.example.appthemovies.network.MovieApi
import kotlinx.coroutines.launch


enum class MovieApiStatus { LOADING, ERROR, DONE; }


class HomeFragmentViewModel : ViewModel() {

    private val _status = MutableLiveData<MovieApiStatus>()

    val status: LiveData<MovieApiStatus> = _status

    private val _getMovies = MutableLiveData<List<MovieModel>>()

    val getMovies: LiveData<List<MovieModel>> = _getMovies

    init {
        initOne()
    }

    private fun initOne() = viewModelScope.launch {
        getMoviesStatus()
    }

    private suspend fun getMoviesStatus() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
        }
        try {
            _getMovies.value = MovieApi.retrofitService.getPopular()
            _status.value = MovieApiStatus.DONE
        } catch (e: Exception) {
            _status.value = MovieApiStatus.ERROR
            _getMovies.value = listOf()
        }

    }
}
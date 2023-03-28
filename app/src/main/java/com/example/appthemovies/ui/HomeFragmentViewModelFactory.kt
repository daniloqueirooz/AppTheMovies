package com.example.appthemovies.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appthemovies.services.MovieApiInterface

class HomeFragmentViewModelFactory(private val movieApiInterface: MovieApiInterface) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeFragmentViewModel(movieApiInterface) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
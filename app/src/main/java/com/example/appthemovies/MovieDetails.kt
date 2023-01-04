package com.example.appthemovies


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.appthemovies.databinding.FragmentMovieDetailsBinding

class MovieDetails : Fragment(R.layout.fragment_movie_details) {


    private var _binding: FragmentMovieDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieDetailsBinding.bind(view)


    }

}
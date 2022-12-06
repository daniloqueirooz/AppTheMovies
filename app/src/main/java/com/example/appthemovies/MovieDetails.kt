package com.example.appthemovies


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.appthemovies.databinding.FragmentMovieDetailsBinding

class MovieDetails : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null

    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieDetailsBinding.bind(view)


    }

}
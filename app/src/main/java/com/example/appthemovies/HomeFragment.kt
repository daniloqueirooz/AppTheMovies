package com.example.appthemovies


import android.os.Bundle

import androidx.fragment.app.Fragment
import com.example.appthemovies.databinding.FragmentHomeBinding
import android.view.View
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.const.Layout


// eu vou criar uma função nova para isolar o click da imagem e passar o argumento para a movie details

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        setupListMovie()

    }

    private fun setupListMovie() {
        binding.apply {

            horizontalRecyclerView.adapter = TheMovieAdapter(
                Layout.HORIZONTAL
            )
            verticalRecyclerView.adapter = TheMovieAdapter(
                Layout.VERTICAL
            )

            horizontalRecyclerView.setHasFixedSize(true)

            verticalRecyclerView.setHasFixedSize(true)
        }

    }

}
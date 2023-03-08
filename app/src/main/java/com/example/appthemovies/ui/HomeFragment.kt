package com.example.appthemovies.ui


import android.os.Bundle
import com.example.appthemovies.databinding.FragmentHomeBinding
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appthemovies.R
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.const.Layout


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: HomeFragmentViewModel


    private lateinit var theMovieAdapter: TheMovieAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setupListMovie()
    }


    private fun setupListMovie() {
        binding.apply {

            horizontalRecyclerView.adapter = TheMovieAdapter(
                Layout.HORIZONTAL
            ) {

                val actions =
                    HomeFragmentDirections.actionHomeFragmentToMovieDetails(it.imageResourceId)
                findNavController().navigate(actions)
            }
            verticalRecyclerView.adapter = TheMovieAdapter(
                Layout.VERTICAL
            )
            {
                val actions =
                    HomeFragmentDirections.actionHomeFragmentToMovieDetails(it.imageResourceId)
                findNavController().navigate(actions)

            }

            horizontalRecyclerView.setHasFixedSize(true)

            verticalRecyclerView.setHasFixedSize(true)
        }


    }

    private fun setupItensView(movieModel: MovieApiStatus) {
        movieModel?.let {
            binding.assistidos.text = movieModel.name
        }
    }


}





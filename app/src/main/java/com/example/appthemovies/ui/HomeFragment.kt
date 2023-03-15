package com.example.appthemovies.ui


import android.os.Bundle
import com.example.appthemovies.databinding.FragmentHomeBinding
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.appthemovies.R
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.const.Layout


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeFragmentViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        viewModel =
            ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
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


}








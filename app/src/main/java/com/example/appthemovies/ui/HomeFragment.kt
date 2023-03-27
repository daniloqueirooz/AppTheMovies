package com.example.appthemovies.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appthemovies.R
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.databinding.FragmentHomeBinding
import com.example.appthemovies.services.MovieApiInterface


class HomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: HomeFragmentViewModel

    private val adapterMovie = TheMovieAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieApiInterface = MovieApiInterface.create()
        viewModel = ViewModelProvider(this, HomeFragmentViewModelFactory(movieApiInterface)).get(HomeFragmentViewModel::class.java)
        viewModel.getMovieData()
        setupLisMovie()
        viewModel.getMovies.observe(viewLifecycleOwner){
            adapterMovie.update(it.results)
        }
    }

    private fun setupLisMovie() {
        binding.apply {
            rvMoviesList.apply {
                adapter = adapterMovie
                val mLayoutManager = LinearLayoutManager(requireContext())
                mLayoutManager.orientation = LinearLayoutManager.VERTICAL
                layoutManager = mLayoutManager
            }
        }
    }
}







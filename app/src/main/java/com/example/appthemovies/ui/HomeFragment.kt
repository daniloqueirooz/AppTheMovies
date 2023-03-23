package com.example.appthemovies.ui


import android.os.Bundle
import com.example.appthemovies.databinding.FragmentHomeBinding
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.appthemovies.R
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.models.Movie
import com.example.appthemovies.models.MovieResponse
import com.example.appthemovies.services.MovieApiInterface
import com.example.appthemovies.services.MovieApiService
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: HomeFragmentViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        setupLisMovie()

        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = TheMovieAdapter(movies)
        }
    }

    private fun setupLisMovie() {
        binding.apply {

            // rvMoviesList.adapter = TheMovieAdapter()
        }

    }

}

private fun getMovieData(callback: (List<Movie>) -> Unit) {
    val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
    apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
        override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

        }

        override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
            return callback(response.body()!!.movies)
        }


    })


}





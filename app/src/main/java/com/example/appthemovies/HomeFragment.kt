package com.example.appthemovies


import android.os.Bundle
import com.example.appthemovies.databinding.FragmentHomeBinding
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.const.Layout


// eu vou criar uma função nova para isolar o click da imagem e passar o argumento para a movie details

class HomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!

    private val theMovieAdapter = TheMovieAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        setupListMovie()
        setupClickFilmes()


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

    private fun setupClickFilmes() {
        theMovieAdapter.setOnClickListener { Movie ->
            val actions =
                HomeFragmentDirections.actionHomeFragmentToMovieDetails(Movie.imageResourceId)
            findNavController().navigate(actions)

            val text = "Hello toast!"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(context, text, duration)
            toast.show()


        }


    }
}







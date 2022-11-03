package com.example.appthemovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.const.Layout

import com.example.appthemovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

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




        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
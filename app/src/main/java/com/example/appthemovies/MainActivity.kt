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

        binding.horizontalRecyclerView.adapter = TheMovieAdapter(
            this,
            Layout.HORIZONTAL
        )
        binding.verticalRecyclerView.adapter = TheMovieAdapter(
            this,
            Layout.VERTICAL
        )

        binding.horizontalRecyclerView.setHasFixedSize(true)

        binding.verticalRecyclerView.setHasFixedSize(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
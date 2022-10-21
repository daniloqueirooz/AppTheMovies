package com.example.appthemovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appthemovies.adapter.TheMovieAdapter
import com.example.appthemovies.const.Layout
import com.example.appthemovies.databinding.ActivityHorizontalListBinding

class HorizontalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Specify fixed size to improve performance
        binding.horizontalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}

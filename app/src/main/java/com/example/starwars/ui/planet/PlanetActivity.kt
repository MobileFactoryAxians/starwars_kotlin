package com.example.starwars.ui.planet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starwars.R
import com.example.starwars.databinding.ActivityPeopleBinding
import com.example.starwars.databinding.ActivityPlanetBinding

class PlanetActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPlanetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
        super.onCreate(savedInstanceState)
        _binding = ActivityPlanetBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbar.backButton.setOnClickListener { onBackPressed() }
    }
}
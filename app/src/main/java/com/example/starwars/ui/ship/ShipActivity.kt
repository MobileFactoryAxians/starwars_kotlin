package com.example.starwars.ui.ship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starwars.R
import com.example.starwars.databinding.ActivityPeopleBinding
import com.example.starwars.databinding.ActivityShipBinding

class ShipActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityShipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
        super.onCreate(savedInstanceState)
        _binding = ActivityShipBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbar.backButton.setOnClickListener { onBackPressed() }
    }
}
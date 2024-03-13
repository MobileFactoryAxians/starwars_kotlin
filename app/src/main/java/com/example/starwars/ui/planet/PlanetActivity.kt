package com.example.starwars.ui.planet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.data.planet.PlanetRepository
import com.example.starwars.databinding.ActivityPlanetBinding
import com.example.starwars.databinding.ListItemBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlanetActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPlanetBinding
    private val mPLanettemAdapter = FastItemAdapter<PlanetItem>()
    val items = ArrayList<ListItemBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
        super.onCreate(savedInstanceState)
        _binding = ActivityPlanetBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val fastAdapter = FastAdapter.with(mPLanettemAdapter)

        val recyclerView: RecyclerView = _binding.planetList
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = fastAdapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbar.backButton.setOnClickListener { onBackPressed() }

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = PlanetRepository.getPlanet()

                result!!.forEach { planet ->
                    runOnUiThread {
                        mPLanettemAdapter.add(PlanetItem(planet))
                    }
                }

                Log.i("TAG", "--> Resposta API feita!")
            }

            catch (e: Exception) {
                Log.e("API_CALL", "--> $e")
            }
        }
    }
}
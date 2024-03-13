package com.example.starwars.ui.ship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.data.ship.ShipRepository
import com.example.starwars.databinding.ActivityShipBinding
import com.example.starwars.databinding.ListItemBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShipActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityShipBinding
    private val mShiptemAdapter = FastItemAdapter<ShiptItem>()
    val items = ArrayList<ListItemBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
        super.onCreate(savedInstanceState)
        _binding = ActivityShipBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val fastAdapter = FastAdapter.with(mShiptemAdapter)

        val recyclerView: RecyclerView = _binding.shipList
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = fastAdapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbar.backButton.setOnClickListener { onBackPressed() }

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = ShipRepository.getShip()

                result!!.forEach { ship ->
                    runOnUiThread {
                        mShiptemAdapter.add(ShiptItem(ship))
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
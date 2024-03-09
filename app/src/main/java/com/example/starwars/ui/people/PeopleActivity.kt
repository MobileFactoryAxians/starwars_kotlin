package com.example.starwars.ui.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.databinding.ActivityHomeBinding
import com.example.starwars.databinding.ActivityPeopleBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class PeopleActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPeopleBinding
    private val mPeopleItemAdapter = FastItemAdapter<PeopleItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val fastAdapter = FastAdapter.with(mPeopleItemAdapter)

        val recyclerView: RecyclerView = _binding.peopleList
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = fastAdapter

        mPeopleItemAdapter.add(listOf(
            PeopleItem().apply { name = "Exemplo 1" },
            PeopleItem().apply { name = "Exemplo 2" },
            PeopleItem().apply { name = "Exemplo 3" }
        ))
    }
}
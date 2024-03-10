package com.example.starwars.ui.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.data.people.PeopleRepository
import com.example.starwars.databinding.ActivityPeopleBinding
import com.example.starwars.databinding.PeopleItemBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PeopleActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPeopleBinding
    private val mPeopleItemAdapter = FastItemAdapter<PeopleItem>()
    val items = ArrayList<PeopleItemBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbar.backButton.setOnClickListener { onBackPressed() }

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = PeopleRepository.getPeople()
                Log.i("TAG", "--> Resposta API feita!")
            }

            catch (e: Exception) {
                Log.e("API_CALL", "--> $e")
            }
        }
    }
}
package com.example.starwars.ui.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.databinding.ActivityPeopleBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class PeopleActivity : AppCompatActivity() {
    private val mPeopleItemAdapter = FastItemAdapter<PeopleItem>()
    private lateinit var mPeopleViewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
        super.onCreate(savedInstanceState)
        val _binding: ActivityPeopleBinding = DataBindingUtil.setContentView(this, R.layout.activity_people)

        // Toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbar.backButton.setOnClickListener { onBackPressed() }

        //ViewModel
        mPeopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        lifecycle.addObserver(mPeopleViewModel)

        //Databinding
        _binding.viewModel = mPeopleViewModel
        _binding.lifecycleOwner = this

        //Fastadapter
        val fastAdapter = FastAdapter.with(mPeopleItemAdapter)
        _binding.peopleList.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = fastAdapter
        }

        //Change values in viewModel
        mPeopleViewModel.people.observe(
            this,
            Observer {
                peopleList ->

                val items = ArrayList<PeopleItem>()
                mPeopleItemAdapter.clear()

                items.clear()

                if (peopleList != null) {
                    peopleList.forEach{
                            people ->
                        items.add(PeopleItem(people))
                    }

                    mPeopleItemAdapter.add(items)
                }
            }
        )
    }
}
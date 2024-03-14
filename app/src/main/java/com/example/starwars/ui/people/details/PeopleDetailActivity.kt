package com.example.starwars.ui.people.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.starwars.R
import com.example.starwars.databinding.ActivityPeopleBinding
import com.example.starwars.databinding.ActivityPeopleDetailBinding
import com.example.starwars.ui.people.PeopleViewModel

class PeopleDetailActivity : AppCompatActivity() {

    lateinit var _binding: ActivityPeopleDetailBinding
    private lateinit var mPeopleDetailViewModel: PeopleDetailViewModel
    companion object {
        const val PEOPLE_NAME : String = "people_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        title=""
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_people_detail)

        // Toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding.appbarDetail.backButton.setOnClickListener { onBackPressed() }

        //ViewModel
        mPeopleDetailViewModel = ViewModelProvider(this).get(PeopleDetailViewModel::class.java)
        _binding.viewModel = mPeopleDetailViewModel

        _binding.lifecycleOwner = this

        intent.getStringExtra(PEOPLE_NAME)?.let {
            mPeopleDetailViewModel.initialize(it)
        }
    }
}
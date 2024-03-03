package com.example.starwars.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.starwars.R
import com.example.starwars.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnPeople.setOnClickListener({
            Toast.makeText(requireContext(), "People", Toast.LENGTH_SHORT).show()
        })

        binding.btnPlanets.setOnClickListener({
            Toast.makeText(requireContext(), "Planets", Toast.LENGTH_SHORT).show()
        })

        binding.btnShips.setOnClickListener({
            Toast.makeText(requireContext(), "Ships", Toast.LENGTH_SHORT).show()
        })

        return view
    }
}
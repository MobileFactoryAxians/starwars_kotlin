package com.example.starwars.ui.home

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.starwars.data.people.PeopleRepository
import com.example.starwars.databinding.ActivityHomeBinding
import com.example.starwars.ui.people.PeopleActivity
import com.example.starwars.ui.planet.PlanetActivity
import com.example.starwars.ui.ship.ShipActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    final val SCALE_X = 157f/258f
    final val SCALE_Y = 71f/118f
    final val MOVE_Y = -900f

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed(
            {
                binding.homelayout.visibility = View.VISIBLE
                animateImage()
            },
            2000
        )

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = PeopleRepository.getPeople()
                Log.i("TAG", "--> Resposta API feita!")
            }

            catch (e: Exception) {
                Log.e("API_CALL", "--> $e")
            }
        }

        binding.btnPeople.setOnClickListener({
            //Toast.makeText(applicationContext, "People", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PeopleActivity::class.java))
        })

        binding.btnShips.setOnClickListener({
            //Toast.makeText(applicationContext, "Ship", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ShipActivity::class.java))
        })

        binding.btnPlanets.setOnClickListener({
            //Toast.makeText(applicationContext, "Planet", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PlanetActivity::class.java))
        })
    }

    private fun animateImage() {
        val image = binding.startimage

        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(image, View.SCALE_X, SCALE_X),
                ObjectAnimator.ofFloat(image, View.SCALE_Y, SCALE_Y),
                ObjectAnimator.ofFloat(image, View.TRANSLATION_Y, MOVE_Y),
                ObjectAnimator.ofFloat(binding.homelayout, "alpha", 0f, 1f)
            )

            duration = 1000
            interpolator = AccelerateInterpolator()

        }.start()
    }
}
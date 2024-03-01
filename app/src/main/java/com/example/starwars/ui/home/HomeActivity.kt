package com.example.starwars.ui.home

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Transformation
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.RelativeLayout.LayoutParams
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LifecycleObserver
import com.example.starwars.R
import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.people.PeopleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    final val SCALE_X = 157f/258f
    final val SCALE_Y = 71f/118f
    final val MOVE_Y = -900f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<View>(R.id.fragment).visibility = View.INVISIBLE

        Handler().postDelayed(
            {
                showStartFragment()
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
    }

    private fun showStartFragment() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fragment, fragment)
            .commit()

        findViewById<View>(R.id.fragment).visibility = View.VISIBLE
    }

    private fun animateImage() {
        val image = findViewById<ImageView>(R.id.startimage)
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment)

        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(image, View.SCALE_X, SCALE_X),
                ObjectAnimator.ofFloat(image, View.SCALE_Y, SCALE_Y),
                ObjectAnimator.ofFloat(image, View.TRANSLATION_Y, MOVE_Y),
                ObjectAnimator.ofFloat(fragment?.view, "alpha", 0f, 1f)
            )

            duration = 1000
            interpolator = AccelerateInterpolator()

        }.start()
    }
}
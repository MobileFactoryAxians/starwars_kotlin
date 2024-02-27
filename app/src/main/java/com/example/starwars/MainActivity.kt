package com.example.starwars

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    companion object {
        private lateinit var sInstance: MainActivity

        fun getAppContext(): Context {
            return sInstance.applicationContext
        }

        var userPermission = ""

        val BASE_URL = "https://swapi.dev/api/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
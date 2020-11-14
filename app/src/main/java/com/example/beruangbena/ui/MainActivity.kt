package com.example.beruangbena.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.beruangbena.R

class MainActivity : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val top_animation = AnimationUtils.loadAnimation(this,
            R.anim.top_animation
        )
        val bot_animation = AnimationUtils.loadAnimation(this,
            R.anim.bot_animation
        )

        val image = findViewById<ImageView>(R.id.img_logo)
        val text1 = findViewById<TextView>(R.id.txt1)

        image.animation = top_animation
        text1.animation = bot_animation

        handler = Handler()
        handler.postDelayed({
            val intent = Intent (this, Walktrought::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
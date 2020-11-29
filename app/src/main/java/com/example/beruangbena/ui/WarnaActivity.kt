package com.example.beruangbena.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.beruangbena.R
import com.example.beruangbena.ui.fragment.HomeFragment
import com.example.beruangbena.ui.fragment.WarnaGamesFragment
import com.example.beruangbena.ui.fragment.WarnaHomeFragment
import kotlinx.android.synthetic.main.activity_warna.*

class WarnaActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warna)
        //Load Fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_warna, WarnaHomeFragment.newInstance())
                .commitNow()
        }
        //Set On click listener
        btn_rumah.setOnClickListener(this)
        btn_exit.setOnClickListener(this)
        btn_games.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_rumah -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_warna, WarnaHomeFragment.newInstance())
                    .commitNow()
            }
            R.id.btn_games -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_warna, WarnaGamesFragment.newInstance())
                    .commitNow()
            }
            R.id.btn_exit -> finish()
        }
    }
}
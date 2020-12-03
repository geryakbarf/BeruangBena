package com.example.beruangbena.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.beruangbena.R
import com.example.beruangbena.ui.fragment.HomeFragment
import com.example.beruangbena.ui.fragment.WarnaGamesFragment
import com.example.beruangbena.ui.fragment.WarnaHomeFragment
import com.example.beruangbena.utils.SessionManager
import kotlinx.android.synthetic.main.activity_warna.*

class WarnaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var sessionManager: SessionManager

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
        //Session
        sessionManager = SessionManager(this)
    }

    private fun getInfoGame(): Boolean? {
        return sessionManager.isInGame()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_rumah -> {
                if (getInfoGame() == false) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_warna, WarnaHomeFragment.newInstance())
                        .commitNow()
                } else
                    Toast.makeText(applicationContext, "Anda sedang dalam game", Toast.LENGTH_SHORT)
                        .show()

            }
            R.id.btn_games -> {
                if (getInfoGame() == false) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_warna, WarnaGamesFragment.newInstance())
                        .commitNow()
                } else
                    Toast.makeText(applicationContext, "Anda sedang dalam game", Toast.LENGTH_SHORT)
                        .show()

            }
            R.id.btn_exit -> {
                if (getInfoGame() == false)
                    finish()
                else
                    Toast.makeText(applicationContext, "Anda sedang dalam game", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }

    override fun onBackPressed() {
        if (getInfoGame() == false)
            super.onBackPressed()
        else
            Toast.makeText(applicationContext, "Anda sedang dalam game", Toast.LENGTH_SHORT)
                .show()
    }
}
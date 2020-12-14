package com.example.beruangbena.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.beruangbena.R
import com.example.beruangbena.ui.fragment.AngkaHomeFragment
import com.example.beruangbena.utils.SessionManager
import kotlinx.android.synthetic.main.activity_angka.*

class AngkaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var sessionManager: SessionManager
    private lateinit var alertBuilder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angka)
        //Load Fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_angka, AngkaHomeFragment.newInstance())
                .commitNow()
        }
        //SetOnclick
        btn_rumah.setOnClickListener(this)
        btn_youtube.setOnClickListener(this)
        imageButton.setOnClickListener(this)
        //Session
        sessionManager = SessionManager(this)
        //Alert Builder
        alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Anda sedang dalam game")
        alertBuilder.setMessage("Apakah anda yakin ingin keluar dari game ?")
        alertBuilder.setCancelable(true)
    }

    private fun getInfoGame(): Boolean? {
        return sessionManager.isInGame()
    }

    private fun clearSession() {
        sessionManager.putIsInGame(false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_rumah -> {
                if (getInfoGame() == false) {
                    clearSession()
                    finish()
                } else {
                    alertBuilder.setPositiveButton("Iya") { _, _ ->
                        clearSession()
                        finish()
                    }
                    alertBuilder.setNegativeButton("Tidak") { _, _ ->
                        //Do Nothing
                    }
                    val mAlertDialog = alertBuilder.create()
                    mAlertDialog.show()
                }
            }
            R.id.btn_youtube -> {

            }
            R.id.imageButton -> {
                if (getInfoGame() == false) {
                    clearSession()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_bangun, AngkaHomeFragment.newInstance())
                        .commitNow()
                } else {
                    alertBuilder.setPositiveButton("Iya") { _, _ ->
                        clearSession()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container_bangun, AngkaHomeFragment.newInstance())
                            .commitNow()
                    }
                    alertBuilder.setNegativeButton("Tidak") { _, _ ->
                        //Do Nothing
                    }
                    val mAlertDialog = alertBuilder.create()
                    mAlertDialog.show()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (getInfoGame() == false) {
            clearSession()
            super.onBackPressed()
        } else {
            alertBuilder.setPositiveButton("Iya") { _, _ ->
                clearSession()
                super.onBackPressed()
            }
            alertBuilder.setNegativeButton("Tidak") { _, _ ->
                //Do Nothing
            }
            val mAlertDialog = alertBuilder.create()
            mAlertDialog.show()
        }
    }
}
package com.example.beruangbena.ui

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.beruangbena.R
import com.example.beruangbena.ui.fragment.HomeFragment
import com.example.beruangbena.ui.fragment.YoutubeFragment
import com.example.beruangbena.utils.BackgroundServices
import kotlinx.android.synthetic.main.activity_dashboar_activitty.*


class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboar_activitty)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
        //Set OnClick Listener
        btn_rumah.setOnClickListener(this)
        btn_youtube.setOnClickListener(this)
        //start soundtrack
        startService(Intent(applicationContext, BackgroundServices::class.java))
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_rumah -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow()
            }
            R.id.btn_youtube -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, YoutubeFragment.newInstance())
                    .commitNow()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val context: Context = applicationContext
        val am =
            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val taskInfo = am.getRunningTasks(1)
        if (taskInfo.isNotEmpty()) {
            val topActivity = taskInfo[0].topActivity
            if (topActivity!!.packageName != context.packageName) {
                stopService(Intent(applicationContext, BackgroundServices::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        startService(Intent(applicationContext, BackgroundServices::class.java))
    }
}
package com.example.beruangbena.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.beruangbena.R
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {

    private var scrore = 0
    private var jumSalah = 0
    private var jumBenar = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        //Load Hasil Skor
        scrore = intent.getIntExtra("score", 100)
        jumSalah = intent.getIntExtra("jumSalah", 0)
        jumBenar = intent.getIntExtra("jumBenar",0)
        //Set Text Berdasarkan Hasil SKor
        txt_totalsalah.text = "$jumSalah Kali"
        txt_totalbenar.text = "$jumBenar Kali"
        txt_Nilai.text = scrore.toString()
        //Mengubah warna text
        if (scrore > 50)
            txt_Nilai.setTextColor(ContextCompat.getColor(this, R.color.Hijau))
        else
            txt_Nilai.setTextColor(ContextCompat.getColor(this, R.color.Merah))
        //Button Finish
        btnFinish.setOnClickListener {
            finish()
        }
    }
}
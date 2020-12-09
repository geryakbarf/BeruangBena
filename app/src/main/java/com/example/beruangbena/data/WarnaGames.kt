package com.example.beruangbena.data

import com.example.beruangbena.R
import com.example.beruangbena.models.WarnaGames

object WarnaGames {
    private val warnaSoal = arrayOf(
        "Merah",
        "Hitam",
        "Putih",
        "Biru",
        "Kuning",
        "Hijau",
        "Ungu",
        "Oranye",
        "Pink",
        "Kelabu"
    )

    private val optioanA = arrayOf(
        "Kuning",
        "Putih",
        "Hitam",
        "Biru",
        "Kuning",
        "Hijau",
        "Oranye",
        "Merah",
        "Hitam",
        "Pink"
    )

    private val optionB = arrayOf(
        "Merah",
        "Hitam",
        "Putih",
        "Kuning",
        "Hijau",
        "Biru",
        "Kelabu",
        "Biru",
        "Putih",
        "Merah"
    )

    private val optionC = arrayOf(
        "Biru",
        "Kelabu",
        "Kelabu",
        "Hijau",
        "Biru",
        "Kuning",
        "Ungu",
        "Oranye",
        "Merah",
        "Biru"
    )

    private val optionD = arrayOf(
        "Hijau",
        "Pink",
        "Merah",
        "Pink",
        "Merah",
        "Ungu",
        "Merah",
        "Pink",
        "Pink",
        "Kelabu"
    )

    private val kodeSoal = intArrayOf(
        R.color.Merah,
        R.color.hitam,
        R.color.Putih,
        R.color.Biru,
        R.color.Kuning,
        R.color.Hijau,
        R.color.Ungu,
        R.color.Oranye,
        R.color.Pink,
        R.color.Kelabu
    )

    private val kodeOptionA = intArrayOf(
        R.color.Kuning,
        R.color.Putih,
        R.color.hitam,
        R.color.Biru,
        R.color.Kuning,
        R.color.Hijau,
        R.color.Oranye,
        R.color.Merah,
        R.color.hitam,
        R.color.Pink
    )

    private val kodeOptionB = intArrayOf(
        R.color.Merah,
        R.color.hitam,
        R.color.Putih,
        R.color.Kuning,
        R.color.Hijau,
        R.color.Biru,
        R.color.Kelabu,
        R.color.Biru,
        R.color.Putih,
        R.color.Merah
    )

    private val kodeOptionC = intArrayOf(
        R.color.Biru,
        R.color.Kelabu,
        R.color.Kelabu,
        R.color.Hijau,
        R.color.Biru,
        R.color.Kuning,
        R.color.Ungu,
        R.color.Oranye,
        R.color.Merah,
        R.color.Biru
    )

    private val kodeOptionD = intArrayOf(
        R.color.Hijau,
        R.color.Pink,
        R.color.Merah,
        R.color.Pink,
        R.color.Merah,
        R.color.Ungu,
        R.color.Merah,
        R.color.Pink,
        R.color.Pink,
        R.color.Kelabu
    )

    val listData: ArrayList<WarnaGames>
        get() {
            val list = arrayListOf<WarnaGames>()
            for (position in warnaSoal.indices) {
                val warna = com.example.beruangbena.models.WarnaGames()
                warna.soal = warnaSoal[position]
                warna.kodeOptionA = kodeOptionA[position]
                warna.kodeOptionB = kodeOptionB[position]
                warna.kodeOptionC = kodeOptionC[position]
                warna.kodeOptionD = kodeOptionD[position]
                warna.optionA = optioanA[position]
                warna.optionB = optionB[position]
                warna.optionC = optionC[position]
                warna.optionD = optionD[position]
                warna.kodeSoal = kodeSoal[position]
                list.add(warna)
            }
            return list
        }
}
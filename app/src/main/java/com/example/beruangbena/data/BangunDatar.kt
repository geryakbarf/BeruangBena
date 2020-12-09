package com.example.beruangbena.data

import com.example.beruangbena.R
import com.example.beruangbena.models.BangunDatar
import com.example.beruangbena.models.Warna

object BangunDatar {
    private val bangunTtitle = arrayOf(
        "Ketupat",
        "Layang - Layang",
        "Lingkaran",
        "Persegi Panjang",
        "Segi Enam",
        "Segi Lima",
        "Segitiga",
        "Trapesium"
    )

    private val bangunDrawable = intArrayOf(
        R.drawable.ketupat,
        R.drawable.layanglayang2,
        R.drawable.lingkaran,
        R.drawable.persegipanjang,
        R.drawable.segienam,
        R.drawable.segilima,
        R.drawable.segitiga,
        R.drawable.trapesium
    )

    val listData: ArrayList<BangunDatar>
        get() {
            val list = arrayListOf<BangunDatar>()
            for (position in bangunTtitle.indices) {
                val bangun = BangunDatar()
                bangun.bangunTtitle = bangunTtitle[position]
                bangun.bangunDrawable = bangunDrawable[position]
                list.add(bangun)
            }
            return list
        }
}
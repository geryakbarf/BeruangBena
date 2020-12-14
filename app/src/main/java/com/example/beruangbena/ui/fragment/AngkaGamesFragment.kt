package com.example.beruangbena.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.beruangbena.R
import com.example.beruangbena.adapter.AdapterAngkaGames
import com.example.beruangbena.data.AngkaGames
import com.example.beruangbena.models.Beruang
import kotlinx.android.synthetic.main.fragment_angka_games.*

class AngkaGamesFragment : Fragment() {

    companion object {
        fun newInstance() = AngkaGamesFragment()
    }

    private var list: ArrayList<com.example.beruangbena.models.AngkaGames> = arrayListOf()
    private var i = 0
    private var listAngka: ArrayList<Beruang> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_angka_games, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Load Item
        rv_beruang.setHasFixedSize(true)
        list.addAll(AngkaGames.listData)
        list.shuffle()
        loadSoal(i)
    }

    private fun loadSoal(i: Int) {
        //Looping untuk membuat item jumlah beruang
        for (a in 1..list[i].angkaNumber) {
            val beruang = Beruang()
            beruang.angka = list[i].angkaNumber
            listAngka.add(beruang)
        }
        //Load Item to recyclerView
        rv_beruang.layoutManager = GridLayoutManager(view?.context, 4)
        val adapterBeruang = AdapterAngkaGames(listAngka)
        rv_beruang.adapter = adapterBeruang
    }

}
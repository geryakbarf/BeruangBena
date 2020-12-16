package com.example.beruangbena.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.beruangbena.R
import com.example.beruangbena.data.Abjad
import com.example.beruangbena.models.Huruf
import kotlinx.android.synthetic.main.fragment_bangun_datar_home.btnNext
import kotlinx.android.synthetic.main.fragment_huruf_home.*

class HurufFragmentHome : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = HurufFragmentHome()
    }

    private var list: ArrayList<Huruf> = arrayListOf()
    private var i = 0
    private var j = 0
    private lateinit var audio: MediaPlayer
    private lateinit var sound: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_huruf_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Load Item
        list.addAll(Abjad.listData)
        j = list.size
        //Set Onlick
        btnNext.setOnClickListener(this)
        btnPrev.setOnClickListener(this)
        img_abjad.setOnClickListener(this)
        //Load Item
        loadItem(i)
    }

    private fun loadItem(i: Int) {
        img_abjad.setImageResource(list[i].gambarAbjad)
        audio = MediaPlayer.create(view?.context, list[i].soundAbjad)
        audio.start()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {
                i += 1
                if (i == j) {
                    i = 0
                    loadItem(i)
                } else
                    loadItem(i)
            }
            R.id.btnPrev -> {
                if(i == 0){
                    i = j-1
                    loadItem(i)
                }else{
                    i -= 1
                    loadItem(i)
                }
            }
            R.id.img_abjad -> {
                sound = MediaPlayer.create(view?.context, list[i].soundAbjad)
                sound.start()
            }
        }
    }
}
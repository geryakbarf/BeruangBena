package com.example.beruangbena.ui.fragment

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.beruangbena.R
import com.example.beruangbena.models.WarnaGames
import com.example.beruangbena.ui.SummaryActivity
import com.example.beruangbena.utils.SessionManager
import kotlinx.android.synthetic.main.fragment_warna_games.*

class WarnaGamesFragment : Fragment() {
    companion object {
        fun newInstance() = WarnaGamesFragment()
    }

    private lateinit var sessionManager: SessionManager
    private var i = 0
    private var j = 1
    private var salah = 0
    private var counterSalah = 0
    private var list: ArrayList<WarnaGames> = arrayListOf()
    private lateinit var alertDialog: AlertDialog
    private lateinit var dialog: View
    private lateinit var btnCobaLagi: Button
    private lateinit var textAnswer: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_warna_games, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Deklarasi Session
        sessionManager = SessionManager(view!!.context)
        //Deklarasi AlertDialog
        alertDialog = AlertDialog.Builder(view?.context).create()
        dialog = LayoutInflater.from(context).inflate(R.layout.alert_dialog_wrong_answer, null)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //AlertDialog ViewBinding
        btnCobaLagi = dialog.findViewById(R.id.btnCobaLagi)
        textAnswer = dialog.findViewById(R.id.textView6)
        btnCobaLagi.setOnClickListener {
            alertDialog.hide()
        }
        //Load and shuffle item
        list.addAll(com.example.beruangbena.data.WarnaGames.listData)
        list.shuffle()
        j = list.size
        //Load Soal
        loadSoal(i)
    }

    private fun loadSoal(i: Int) {
        btn_bulaSoal.backgroundTintList =
            view?.context?.let { ContextCompat.getColorStateList(it, list[i].kodeSoal) }
        txt_pilih.text = """Pilih mana yang berwarna ${list[i].soal} ? """
        btn_bulatMerah?.background =
            view?.context?.let { ContextCompat.getDrawable(it, list[i].kodeOptionA) }
        btn_bulatHitam?.background =
            view?.context?.let { ContextCompat.getDrawable(it, list[i].kodeOptionB) }
        btn_bulatHijau?.background =
            view?.context?.let { ContextCompat.getDrawable(it, list[i].kodeOptionC) }
        btn_bulatBiru?.background =
            view?.context?.let { ContextCompat.getDrawable(it, list[i].kodeOptionD) }
        //SetOnclickListener untuk pengecekan jawaban
        btn_bulatMerah.setOnClickListener {
            validation(list[i].soal, list[i].optionA)
        }
        btn_bulatHitam.setOnClickListener {
            validation(list[i].soal, list[i].optionB)
        }
        btn_bulatHijau.setOnClickListener {
            validation(list[i].soal, list[i].optionC)
        }
        btn_bulatBiru.setOnClickListener {
            validation(list[i].soal, list[i].optionD)
        }
    }

    private fun validation(answer: String, option: String) {
        if (answer == option) {
            //Jika Jawaban Benar
            sessionManager.putIsInGame(true)
            this@WarnaGamesFragment.i += 1
            checkQuestionNumber()
        } else {
            //Jika Jawaban salah
            salah += 5
            counterSalah += 1
            //Set Text On Alert Dialog
            textAnswer.text = "Buah yang kamu pilih berwarna $option"
            //Show Alert Dialog
            alertDialog.setView(dialog)
            alertDialog.show()
        }
    }

    private fun checkQuestionNumber() {
        if (i == j) {
            var score = 100
            if (salah > score) score = 0
            sessionManager.putIsInGame(false)
            val intent = Intent(view?.context, SummaryActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("jumSalah", counterSalah)
            startActivity(intent)
            activity?.finish()
        } else
            loadSoal(i)
    }

}
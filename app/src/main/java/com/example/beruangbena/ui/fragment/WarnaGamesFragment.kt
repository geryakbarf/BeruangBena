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
import android.widget.Toast
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
    private var i = 0;
    private var j = 1;
    private var salah = 0;
    private var list: ArrayList<WarnaGames> = arrayListOf()
    private lateinit var alertDialog: AlertDialog
    private lateinit var dialog: View
    private lateinit var btnCobaLagi: Button
    private lateinit var imgAnswer: Button

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
        imgAnswer = dialog.findViewById(R.id.imageView3)
        btnCobaLagi.setOnClickListener {
            alertDialog.hide()
        }
        //Load and shuffle item
        list.addAll(com.example.beruangbena.data.WarnaGames.listData)
        list.shuffle()
        j = list.size
        loadSoal(i)
    }

    private fun loadSoal(i: Int) {
        btn_bulaSoal.backgroundTintList =
            view?.context?.let { ContextCompat.getColorStateList(it, list[i].kodeSoal) }
        button.text = list[i].optionA
        btn_bulatHitam.text = list[i].optionB
        btn_bulatHijau.text = list[i].optionC
        btn_bulatBiru.text = list[i].optionD
        //SetOnclickListener untuk pengecekan jawaban
        button.setOnClickListener {
            validation(list[i].soal, list[i].optionA, list[i].kodeOptionA)
        }
        btn_bulatHitam.setOnClickListener {
            validation(list[i].soal, list[i].optionB, list[i].kodeOptionB)
        }
        btn_bulatHijau.setOnClickListener {
            validation(list[i].soal, list[i].optionC, list[i].kodeOptionC)
        }
        btn_bulatBiru.setOnClickListener {
            validation(list[i].soal, list[i].optionD, list[i].kodeOptionD)
        }
    }

    private fun validation(answer: String, option: String, kodeOption: Int) {
        if (answer == option) {
            sessionManager.putIsInGame(true)
            this@WarnaGamesFragment.i += 1
            checkQuestionNumber()
        } else {
            salah += 5
            //Set color button option
            imgAnswer.backgroundTintList =
                dialog.context?.let { ContextCompat.getColorStateList(it, kodeOption) }
            //set color button try again
            btnCobaLagi.backgroundTintList =
                dialog.context?.let { ContextCompat.getColorStateList(it, kodeOption) }
            //set button try again text color
            if (option == "Putih" || option == "Kuning" || option == "Hijau")
                btnCobaLagi.setTextColor(
                    ContextCompat.getColorStateList(
                        dialog.context,
                        R.color.hitam
                    )
                )
            else
                btnCobaLagi.setTextColor(
                    ContextCompat.getColorStateList(
                        dialog.context,
                        R.color.Putih
                    )
                )
            //Show Alert Dialog
            alertDialog.setView(dialog)
            alertDialog.show()
        }
    }

    private fun checkQuestionNumber() {
        if (i == j) {
            val score = 100 - salah
            sessionManager.putIsInGame(false)
            val intent = Intent(view?.context, SummaryActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            activity?.finish()
        } else
            loadSoal(i)
    }

}
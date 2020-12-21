package com.example.beruangbena.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.beruangbena.R
import com.example.beruangbena.ui.AngkaActivity
import com.example.beruangbena.ui.BangunDatarActivity
import com.example.beruangbena.ui.HurufActivity
import com.example.beruangbena.ui.WarnaActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {


    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_warna.setOnClickListener(this)
        btn_bentuk.setOnClickListener(this)
        btn_angka.setOnClickListener(this)
        btn_huruf.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_warna -> view?.context?.startActivity(
                Intent(
                    view?.context,
                    WarnaActivity::class.java
                )
            )
            R.id.btn_bentuk -> view?.context?.startActivity(
                Intent(
                    view?.context,
                    BangunDatarActivity::class.java
                )
            )
            R.id.btn_angka -> view?.context?.startActivity(
                Intent(
                    view?.context,
                    AngkaActivity::class.java
                )
            )
            R.id.btn_huruf -> view?.context?.startActivity(
                Intent(view?.context, HurufActivity::class.java)
            )
        }
    }

}
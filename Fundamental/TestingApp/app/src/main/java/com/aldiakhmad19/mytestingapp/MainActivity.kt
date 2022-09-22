package com.aldiakhmad19.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Eror NullPointerException muncul karena kita mencoba menekan button yang belum diinisiasi
    // (masih bernilai null)
    private var btnSetValue:Button? =null
    private lateinit var tvText:TextView

    private var names = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tv_text)

        btnSetValue!!.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id== R.id.btn_set_value) {
            tvText.text ="21"
        }
    }
}
package com.aldiakhmad19.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSetValue:Button
    private lateinit var tvText:TextView

    private var names = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tv_text)
        btnSetValue = findViewById(R.id.btn_set_value)

        btnSetValue.setOnClickListener(this)

        names.add("Akhmad")
        names.add("aldi")
        names.add("bismillah Lulus")

    }

    override fun onClick(v: View) {
        if (v.id== R.id.btn_set_value) {
            Log.d("MainActivity",names.toString())
            val name = StringBuilder()
            // java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
            // sebuah collection dimulai dari 0, maka item terakhirnya berada pada indeks ke 2.
            // for (i in 0..3){

            for (i in 0..2){
                name.append(names[i]).append("\n")
            }
            tvText.text= name.toString()
        }
    }
}
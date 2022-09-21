package com.aldiakhmad19.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity:Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
                // Untuk context dapat menggunakan this yang menandakan obyek kelas saat ini.
                // Sedangkan kelas tujuan selalu diakhiri dengan menggunakan class
                // Context adalah sebuah kelas yang digunakan untuk mengakses resource dari activity tersebut.
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                // startActivity(moveIntent) akan menjalankan activity baru tanpa membawa data.
                startActivity(moveIntent)
            }
        }
    }
}
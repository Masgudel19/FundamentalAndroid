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

        val btnMoveWithDataActivity:Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)
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

            R.id.btn_move_activity_data ->{
                val moveWithDataIntent = Intent(this@MainActivity,MoveWithDataActivity::class.java)
                // metode putExtra() untuk mengirimkan data bersamaan dengan obyek Intent
                // metode putExtra() sendiri merupakan metode yang menampung pasangan key-value
                // EXTRA_NAME adalah variabel static bertipe data string dan bernilai extra_name pada MoveWithDataActivity.
                // DicodingAcademy Gudel dengan tipe data string.
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Gudel")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,21)
                startActivity((moveWithDataIntent))

            }
        }
    }
}
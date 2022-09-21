package com.aldiakhmad19.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        // EXTRA_PERSON merupakan variabel static bertipe data string dan bernilai “extra_person”.
        // Berfungsi sebagai key untuk mendapatkan value data yang dikirim
        // getIntent().getParcelableExtra(Key) digunakan untuk mengambil nilai obyek person yang sebelumnya telah dikirim hanya dengan satu variabel
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text =
            "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nCity:${person.city}"
        tvObject.text = text

    }

}

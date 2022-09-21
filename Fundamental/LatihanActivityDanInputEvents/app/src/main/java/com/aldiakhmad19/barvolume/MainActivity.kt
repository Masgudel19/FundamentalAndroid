package com.aldiakhmad19.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//ditambahkan di mainactivity karena inherit (turunan) dari superclass bernama AppCompatActivity
// Ini adalah listener yang kita implementasikan untuk memantau kejadian klik pada komponen tombol (button).
class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Kode di bawah mendeklarasikan semua komponen view yang akan dimanipulasi. dideklarasikan secara global
    // agar bisa dikenal di keseluruhan bagian kelas.
    private lateinit var edtWidth:EditText
    private lateinit var edtHeight:EditText
    private lateinit var edtLength:EditText
    private lateinit var btnCalculate:Button
    private lateinit var tvResult: TextView


    companion object{
        private const val STATE_RESULT = "state_result"

    }

    // onCreate() merupakan metode utama pada Activity. Di sinilah kita dapat mengatur layout xml.
    // Semua proses inisialisasi komponen yang digunakan akan dijalankan di sini.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setcontentview digunakan untuk menampilkan tampilan yang berasal dari layout activity_main.xml.
        setContentView(R.layout.activity_main)

        // findViewById berfungsi untuk menghubungkan variabel yang di buat sebelumnya dengan id yang
        // sudah kita buat di dalam layout activity_main.xml
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate=findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)


        // Keyword this merujuk pada objek Activity saat ini yang telah mengimplementasikan
        // listener OnClickListener sebelumnya.  Sehingga ketika btnCalculate diklik
        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvResult.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false

            //.isEmpty() berfungsi untuk mengecek apakah inputan dari edittext itu masih kosong.
            if (inputLength.isEmpty()){
                isEmptyFields =true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyFields=true
                edtHeight.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }

            // !isEmptyFields memiliki arti "jika semua inputan tidak kosong". Jika kondisi tersebut terpenuhi maka langkah
            // selanjutnya yaitu melakukan proses perhitungan, namun di sini kita tidak dapat langsung melakukan perhitungan
            if (!isEmptyFields){
                val volume = inputLength.toDouble()*inputWidth.toDouble()* inputHeight.toDouble()
                tvResult.text=volume.toString()
            }

        }
    }
}
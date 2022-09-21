package com.aldiakhmad19.myintentapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


// Anotasi @Parcelize di atas nama kelas, digunakan untuk memberi tanda bahwa kelas ini yang dipilih untuk menjadi parcelable.
// @Parcelize juga otomatis men-generate semua kode yang digunakan untuk implemetasi parcelize sebelumnya.
@Parcelize
data class Person(
    val name:String?,
    val age:Int?,
    val email:String?,
    val city:String?
) : Parcelable

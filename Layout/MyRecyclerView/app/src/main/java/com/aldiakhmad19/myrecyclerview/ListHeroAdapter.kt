package com.aldiakhmad19.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHeroAdapter (private val ListHero:ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    //  digunakan untuk membuat ViewHolder baru yang berisi layout item yang digunakan
    // Metode ini membuat serta menginisialisasi ViewHolder dan View yang akan diatribusikan.
    // Namun, pada fungsi ini tidak bertujuan mengisi konten tampilan, sehingga belum terikat dengan data tertentu.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent,false)
        return ListViewHolder(view)
    }


    // digunakan untuk menetapkan data yang ada ke dalam ViewHolder sesuai dengan posisinya dengan menggunakan listHero[position].
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description,photo) = ListHero[position]
        // Glide berfungsi untuk memuat gambar. Kita bisa dengan mudah untuk memuat gambar yang datanya berasal dari sebuah URL.
        Glide.with(holder.itemView.context)
            .load(photo)// URL Gambar
            .circleCrop()// Mengubah Image menjadi Lingkaran
            .into(holder.imgPhoto) // image view mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(ListHero[holder.adapterPosition]) }

    }
    // digunakan untuk menetapkan ukuran dari list data yang ingin ditampilkan. Karena kita ingin menampilkan semua data,
    // maka kita menggunakan listHero.size untuk mengetahui jumlah data pada list.
    override fun getItemCount(): Int = ListHero.size

    //Kelas ListViewHolder digunakan sebagai ViewHolder dalam RecyclerView. ViewHolder adalah wrapper seperti VIew yang berisi layout untuk setiap item dalam daftar RecyclerView.
    // Di sinilah tempat untuk menginisialisasi setiap komponen pada layout item dengan menggunakan itemView.findViewById.
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto:ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName:TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription:TextView = itemView.findViewById(R.id.tv_item_description)
    }
    // Proses yang mengatribusikan tampilan ke datanya disebut binding.
    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}
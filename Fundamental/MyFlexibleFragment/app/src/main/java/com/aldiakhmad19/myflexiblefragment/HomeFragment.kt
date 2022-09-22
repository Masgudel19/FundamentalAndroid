package com.aldiakhmad19.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {

    // onCreateView() di mana layout interface didefinisikan dan ditransformasikan dari layout
    // berupa file xml ke dalam objek view dengan menggunakan metode inflate().
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflater.inflate() merupakan objek dari LayoutInflater yang berfungsi untuk mengubah
        // layout xml ke dalam bentuk objek viewgroup atau widget melalui pemanggilan metode inflate().

        return inflater.inflate(R.layout.fragment_home,container,false)
    }
    // onViewCreated() gunakan untuk inisialisasi view, dan juga mengatur action-nya (set listener).
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // asting objek button dilakukan dengan view.findViewById(R.id.btn_category).
        val btnCategory:Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id== R.id.btn_category){
            val mCategoryFragment = CategoryFragment()
            // Fragment menggunakan parentFragmentManager untuk mendapatkan FragmentManager dari Activity.
            // Setelah mendapatkannya, Anda dapat memulai transaksi pergantian fragment.
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                // menggunakan method replace() dan bukan add() ketika ingin menempelkan sebuah fragment baru.
                replace(R.id.frame_container,mCategoryFragment,CategoryFragment::class.java.simpleName)
                // .addToBackStack(null) setelahnya? Kita menggunakannya karena objek fragment yang saat ini diciptakan masuk
                // ke dalam sebuah fragment stack.  Nantinya ketika kita tekan tombol back, ia akan pop-out keluar dari stack
                // dan menampilkan objek fragment sebelumnya HomeFragment.
                addToBackStack(null)
                commit()
            }
        }
    }
}
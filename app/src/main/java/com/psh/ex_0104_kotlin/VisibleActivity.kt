package com.psh.ex_0104_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class VisibleActivity : AppCompatActivity() {

    lateinit var btn_inv:Button
    lateinit var img1:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visible)

        btn_inv = findViewById(R.id.btn_inv)
        img1 = findViewById(R.id.img1)

        btn_inv.setOnClickListener(View.OnClickListener {
            if(img1.visibility == View.VISIBLE){
                img1.visibility = View.INVISIBLE
            }else{
                img1.visibility = View.VISIBLE
            }
        })

    }
}
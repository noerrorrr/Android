package com.psh.ex_0104_kotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView

class SharedActivity : AppCompatActivity() {

    lateinit var txt:TextView
    lateinit var btn_up:Button
    lateinit var btn_down:Button

    lateinit var pref:SharedPreferences
    var num:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        pref = PreferenceManager.getDefaultSharedPreferences(this)
        num = pref.getInt("save", 0)

        txt = findViewById(R.id.txt)
        btn_up = findViewById(R.id.btn_up)
        btn_down = findViewById(R.id.btn_down)

        //pref를 통해서 불러온 값을 txt에 추가
        txt.text = num.toString()

        btn_up.setOnClickListener {
            txt.text = (++num).toString()
        }
        btn_down.setOnClickListener {
            txt.text = (--num).toString()
        }

    }

    override fun onStop() {
        super.onStop()
        //앱이 종료되는 시점에 num값을 저장
        var edit = pref.edit()
        edit.putInt("save",num)
        edit.commit()
    }

}
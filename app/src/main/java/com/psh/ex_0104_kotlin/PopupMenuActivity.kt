package com.psh.ex_0104_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.PopupMenu.OnMenuItemClickListener
import android.widget.Toast

class PopupMenuActivity : AppCompatActivity() {

    lateinit var btn_show:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)
        btn_show = findViewById(R.id.btn_show)
        btn_show.setOnClickListener(View.OnClickListener { view ->
            //팝업 메뉴 생성 및 호출
            var popup = PopupMenu(this@PopupMenuActivity, view)

            //생성된 팝업클래스에 my_meny.xml을 추가
            menuInflater.inflate(R.menu.my_menu, popup.menu)

            //팝업메뉴에 이벤트감지자 등록
            popup.setOnMenuItemClickListener(click)

            popup.show()
        })
    }
    var click = OnMenuItemClickListener{ item ->
        when(item.itemId){
            R.id.m1 -> {Toast.makeText(this@PopupMenuActivity, "m1", Toast.LENGTH_SHORT).show()}
            R.id.m2 -> {finish()}
        }

        true
    }
}
package com.psh.ex_0104_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener

class SwipeActivity : AppCompatActivity() {

    lateinit var swipe:SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        swipe = findViewById(R.id.swipe)

        //디스크 색상
        swipe.setProgressBackgroundColorSchemeColor(
            Color.parseColor("#aaaaff"))

        //디스크 사이즈
        swipe.setSize(SwipeRefreshLayout.LARGE)

        //감지자 등록
        swipe.setOnRefreshListener(listener)

    }//onCreate()

    var listener = OnRefreshListener{
        Toast.makeText(this, "토스트 호출", Toast.LENGTH_SHORT).show()
        handler.sendEmptyMessageDelayed(0,3000)
    }

    //3초간 로딩을 한다고 가정하는 핸들러
    //object: 객체를 한 개만 생성하게 해 주는 싱글톤 개념
    var handler = object : Handler(){
        override fun handleMessage(msg: Message) {
            swipe.isRefreshing = false
        }
    }
}













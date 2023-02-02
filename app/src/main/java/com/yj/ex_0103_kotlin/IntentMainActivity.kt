package com.yj.ex_0103_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class IntentMainActivity : AppCompatActivity() {

    lateinit var btn_link:Button
    lateinit var btn_call:Button
    lateinit var btn_camera:Button
    lateinit var btn_next:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_main)

        btn_link = findViewById(R.id.btn_link)
        btn_call = findViewById(R.id.btn_call)
        btn_camera = findViewById(R.id.btn_camera)
        btn_next = findViewById(R.id.btn_next)

        btn_link.setOnClickListener(click)
        btn_call.setOnClickListener(click)
        btn_camera.setOnClickListener(click)
        btn_next.setOnClickListener(click)

    }//onCreate()

    var click:View.OnClickListener = View.OnClickListener { view ->

        when( view.id ){
            R.id.btn_link -> {
                //Intent i = new Intent(Intent.ACTION_VIEW)
                //i.setData(Uri.parse("https://www.naver.com"))
                //startActivity(i)

                var i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse("https://www.naver.com")
                startActivity(i)
            }
            R.id.btn_call -> {
                var i = Intent(Intent.ACTION_DIAL)
                i.data = Uri.parse("tel:01011112222")
                startActivity(i)
            }
            R.id.btn_camera -> {
                var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(i)
            }
            R.id.btn_next -> {
                //화면 전환
                var i = Intent(this@IntentMainActivity, MainActivity::class.java)
                i.putExtra("save", "안녕하세요")
                startActivity(i)
            }

        }//when
    }
}














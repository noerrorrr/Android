package com.psh.ex_0104_kotlin

import android.app.AlertDialog.Builder
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
    }

    override fun onBackPressed() {
        //뒤로가기 버튼 클릭을 감지하는 메서드
        var alert = Builder(this@AlertActivity)
        alert.setTitle("앱 이름")
        alert.setMessage("종료하시겠습니까?")
        //버튼 한개를 추가
        alert.setPositiveButton("네",
            DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
        alert.setNegativeButton("아니요", null)
        alert.show()
    }

}
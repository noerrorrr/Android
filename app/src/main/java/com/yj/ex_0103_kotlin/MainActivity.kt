package com.yj.ex_0103_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var txt:TextView

    var test:Test = Test()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //settitle로 상단 텍스트 바꾸기
        title = "계산기"

        e1 = findViewById(R.id.e1)
        e2 = findViewById(R.id.e2)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        txt = findViewById(R.id.txt)

        //IntentMainActivity에서 넘어온 Intent
        var i = intent
        var str:String? = i.getStringExtra("save")
        txt.text = str

        btn1.setOnClickListener( click )
        btn2.setOnClickListener( click )
        btn3.setOnClickListener( click )
        btn4.setOnClickListener( click )

    }//onCreate()

    var click:View.OnClickListener = View.OnClickListener { view ->

        var num1:Int = e1.text.toString().toInt()
        var num2:Int = e2.text.toString().toInt()

        //var op:String = ((Button)view).getText().toString()
        //as로 캐스팅
        var op:String =(view as Button).text.toString()

        var res:Int = test.result(num1, num2, op);
        txt.text = res.toString()

    }

    //View.OnClickListener click = new View.OnClick...
    //감지자 만들기
    /* var click:View.OnClickListener = View.OnClickListener {view ->

        //editText의 값이 비어 있는지 체크
        if( e1.text.toString() == "" ){
            e1.setText("0")
        }

        if( e2.text.toString() == "" ){
            e2.setText("0")
        }

        var num1:Int = e1.text.toString().toInt()
        var num2:Int = e2.text.toString().toInt()

        when(view.id){
            R.id.btn1 -> {
                //+
                txt.setText( "" + (num1 + num2) )
            }
            R.id.btn2 -> {
                //-
                txt.text = (num1 - num2).toString()
            }
            R.id.btn3 -> {
                txt.text = (num1 * num2).toString()
            }
            R.id.btn4 -> {
                try {
                    txt.text = (num1 / num2).toString()
                }catch (e:Exception){
                    Toast.makeText( this@MainActivity, "0으로는 나눌 수 없음",
                    Toast.LENGTH_SHORT).show()

                }

            }


        }//when

    }*/
}









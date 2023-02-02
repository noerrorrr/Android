package com.psc.ex_1220;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentSubActivity extends AppCompatActivity {

    TextView txt_name, txt_age, txt_tel, txt_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sub);

        // Main에서 넘겨준 intent를 받는다
        Intent intent = getIntent();

        // intent에 담겨진 내용을 읽어오자
        String name = intent.getStringExtra("m_name");
        String age = intent.getStringExtra("m_age");
        String tel = intent.getStringExtra("m_tel");
        String birth = intent.getStringExtra("m_birth");

        txt_name = findViewById(R.id.txt_name);
        txt_age = findViewById(R.id.txt_age);
        txt_tel = findViewById(R.id.txt_tel);
        txt_birth = findViewById(R.id.txt_birth);

        txt_name.setText("이름 : " + name);
        txt_age.setText("나이 : " + age);
        txt_tel.setText("전화 : " + tel);
        txt_birth.setText("생일 : " + birth);

    } // onCreate()
}
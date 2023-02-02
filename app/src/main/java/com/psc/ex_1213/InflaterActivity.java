package com.psc.ex_1213;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class InflaterActivity extends AppCompatActivity {

    LinearLayout linear;
    View myView;

    // xml파일을 view구조로 변경해주는 클래스
    LayoutInflater linf;

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);

        linear = findViewById(R.id.linear);
        linf = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

        // ex_inflater.xml을 myView라는 view구조로 변경
        // myView = linf.inflate(R.layout.ex_inflater, null);

        // 위의 코드와 아래의 코드를 하나로 병합한 코드
        myView = linf.inflate(R.layout.ex_inflater, linear);

        btn1 = myView.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        InflaterActivity.this,
                        "버튼1", Toast.LENGTH_SHORT).show();
            }
        });

        // linear.addView(myView);
    } // onCreate()
}
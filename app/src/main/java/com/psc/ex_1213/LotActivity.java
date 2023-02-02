package com.psc.ex_1213;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LotActivity extends AppCompatActivity {

    TextView txt_result;
    Button btn1, btn2, btn3, btn4, btn_re;
    int rnd; // 난수발생용 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot);

        txt_result = findViewById(R.id.txt_result);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn_re = findViewById(R.id.btn_re);

        setRandom();

        btn1.setOnClickListener(click);
        btn2.setOnClickListener(click);
        btn3.setOnClickListener(click);
        btn4.setOnClickListener(click);

        // 다시하기 버튼 이벤트 감지자
        btn_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandom();
                txt_result.setText("결과");
            }
        });

    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // 클릭된 버튼에 쓰여진 텍스트를 가져오기
            String s = ((Button)view).getText().toString();
            if ( Integer.parseInt(s) == rnd ) {
                txt_result.setText("당첨");
            } else {
                txt_result.setText("꽝");
            }

        }
    };

    // 난수발생 메소드
    private void setRandom() {
        rnd = new Random().nextInt(4) + 1;
    }
}
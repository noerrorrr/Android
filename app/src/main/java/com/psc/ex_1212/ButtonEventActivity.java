package com.psc.ex_1212;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonEventActivity extends AppCompatActivity {

    Button btn_r, btn_g, btn_b, btn2_r, btn2_g, btn2_b;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_event);

        // 이벤트에 사용할 객체들 검색(메모리 할당)
        btn_r = findViewById(R.id.btn_r);
        btn_g = findViewById(R.id.btn_g);
        btn_b = findViewById(R.id.btn_b);
        btn2_r = findViewById(R.id.btn2_r);
        btn2_g = findViewById(R.id.btn2_g);
        btn2_b = findViewById(R.id.btn2_b);
        txt = findViewById(R.id.txt);

        // 각 버튼에 이벤트 감지자 등록
        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // txt의 배경색을 변경하자
                txt.setBackgroundColor(Color.parseColor("#ff0000"));
            }
        });

        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // txt의 배경색을 변경하자
                txt.setBackgroundColor(Color.parseColor("#00ff00"));
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // txt의 배경색을 변경하자
                txt.setBackgroundColor(Color.parseColor("#0000ff"));
            }
        });

        // 이벤트 처리를 위한 두번째 방법(감지자를 한개만 만들어서 참조)
        btn2_r.setOnClickListener( click );
        btn2_g.setOnClickListener( click );
        btn2_b.setOnClickListener( click );

    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btn2_r:
                    txt.setText("빨강");
                    break;

                case R.id.btn2_g:
                    txt.setText("초록");
                    break;

                case R.id.btn2_b:
                    txt.setText("파랑");
                    break;

            } // switch

        }
    };

}
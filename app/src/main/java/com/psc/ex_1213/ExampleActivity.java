package com.psc.ex_1213;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ExampleActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, restart;
    TextView result;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Random random = new Random();
        a = random.nextInt(4) + 1;

        // 이벤트에 사용할 객체들 검색(메모리 할당)
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        restart = findViewById(R.id.restart);
        result = findViewById(R.id.result);

        // 버튼에 이벤트 감지자 등록
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Result");
                Random random = new Random();
                a = random.nextInt(4) + 1;
            }
        });

        // 이벤트 처리를 위한 두번째 방법(감지자를 한개만 만들어서 참조)
        btn_1.setOnClickListener( click );
        btn_2.setOnClickListener( click );
        btn_3.setOnClickListener( click );
        btn_4.setOnClickListener( click );

    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btn_1:
                    if (a == 1) {
                        result.setText("당첨");
                    } else {
                        result.setText("꽝");
                    }
                    break;

                case R.id.btn_2:
                    if (a == 2) {
                        result.setText("당첨");
                    } else {
                        result.setText("꽝");
                    }
                    break;

                case R.id.btn_3:
                    if (a == 3) {
                        result.setText("당첨");
                    } else {
                        result.setText("꽝");
                    }
                    break;

                case R.id.btn_4:
                    if (a == 4) {
                        result.setText("당첨");
                    } else {
                        result.setText("꽝");
                    }
                    break;

            } // switch

        }
    };

}
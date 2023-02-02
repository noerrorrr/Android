package com.psc.ex_1219;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {

    TextView value;
    Button btn_start, btn_stop, btn_reset;

    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        value = findViewById(R.id.value);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_reset = findViewById(R.id.btn_reset);

        btn_start.setOnClickListener(click);
        btn_stop.setOnClickListener(click);
        btn_reset.setOnClickListener(click);

    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ) {

                case R.id.btn_start:
                    // 핸들러 호출(동작)

                    // handleMessage()를 호출한다!
                    handler.sendEmptyMessage(0);

                    // 시작버튼 클릭 방지
                    btn_start.setEnabled(false);
                    break;

                case R.id.btn_stop:
                    // 핸들러 정지
                    handler.removeMessages(0);

                    // 시작버튼 활성화
                    btn_start.setEnabled(true);
                    break;

                case R.id.btn_reset: // 초기화
                    num = 0;
                    // value.setText("" + num);
                    value.setText(String.valueOf(num));
                    break;

            } // switch

        }
    };

    // 안드로이드에서 스레드의 역할을 담당하는 핸들러
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 백그라운드에서 코드를 실행하는 영역

            // 1초 간격으로 handleMessage영역을 반복호출
            handler.sendEmptyMessageDelayed(0, 1000);

            num++;
            value.setText(String.valueOf(num));
        }
    };
}
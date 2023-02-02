package com.psc.ex_1220;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class WorkActivity extends AppCompatActivity {

    int num = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    } // onCreate()

    // 뒤로가기 버튼 클릭을 감지하는 메소드
    @Override
    public void onBackPressed() {

        if ( num != 2 ) {
            finish();
        } else {
            Toast.makeText(this, "뒤로가기를 한 번 더 누르면 종료", Toast.LENGTH_SHORT).show();
            handler.sendEmptyMessage(0);
        }

    } // backPressed

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // num을 1씩 감소
            handler.sendEmptyMessageDelayed(0, 1000);

            if ( num > 0 ) {
                num--;
            } else {
                num = 2;
                handler.removeMessages(0);
            }

        }
    };

}
package com.psc.ex_1212;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        // 애플리케이션 실행 시 가장 먼저 호출되는 메소드
        Log.i("MY", "--onCreate--");

    } // onCreate()

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MY", "--onDestroy--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MY", "--onPause--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MY", "--onRestart--");

        // Context : 액티비티의 정보를 담고있는 클래스
        Toast.makeText(
                LifeCycleActivity.this,
                "토스트 실행됨",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY", "--onResume--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MY", "--onStart--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MY", "--onStop--");
    }
}

// 앱을 최초로 실행했을 때
// onCreate() -- 딱 한번만 호출
// onStart()
// onResume()

// 홈 버튼으로 바탕화면으로 나갔을 때
// onPause()
// onStop()

// 다시 앱으로 복귀했을 때
// onRestart()
// onStart()
// onResume()

// 뒤로가기로 앱을 완전히 종료했을 때
// onPause()
// onStop()
// onDestroy() -- 완전히 종료될 때 딱 한번만 호출
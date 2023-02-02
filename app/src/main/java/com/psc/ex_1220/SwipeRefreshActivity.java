package com.psc.ex_1220;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class SwipeRefreshActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        swipe = findViewById(R.id.swipe);

        // 디스크 색상 변경
        swipe.setProgressBackgroundColorSchemeColor(
                Color.parseColor("#aaaaff") );

        // 디스크 크기 변경
        swipe.setSize( SwipeRefreshLayout.LARGE );

        // 당겨질 끝 위치 지정 (애니메이션, 끝 위치)
        swipe.setProgressViewEndTarget(true, 500);

        // 디스크 가운데 원래 검정색이었던 그 막... 돌아가는...
        // 안과검사할때 쓰는거 같은.. 그 왜.. 그 모양 그거 색깔 변경
        swipe.setColorSchemeResources(R.color.c1, R.color.c2, R.color.c3);

        // 디스크가 당겨진 것을 감지하는 감지자
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(SwipeRefreshActivity.this,
                        "당겨짐", Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        });
    } // onCreate()

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 3초간 서버와 통신을 한다고 가정한 핸들러
            swipe.setRefreshing(false); // 디스크 제거
        }
    };

}
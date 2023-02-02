package com.psc.ex_1219;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {

    TextView time_out, record;
    Button btn_start, btn_rec;
    ScrollView scroll;

    final int INIT = 0; // 초기상태
    final int RUN = 1; // 진행중
    final int PAUSE = 2; // 일시정지

    // 현재 상태를 저장할 변수
    int cur_status = INIT;

    int myCount = 1;

    // 스톱워치의 진행상황을 저장할 변수들
    long myBaseTime, myPauseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        scroll = findViewById(R.id.scroll);
        time_out = findViewById(R.id.time_out);
        record = findViewById(R.id.record);

        btn_start = findViewById(R.id.btn_start);
        btn_rec = findViewById(R.id.btn_rec);

        btn_start.setOnClickListener(click);
        btn_rec.setOnClickListener(click);

    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ) {

                case R.id.btn_start:
                    switch ( cur_status ) {
                        case INIT:
                            // 현재 앱이 실행되고 나서
                            // elapsedRealtime() 메소드가 호출되기 까지 경과된 시간
                            myBaseTime = SystemClock.elapsedRealtime();

                            // 핸들러 호출
                            myTimer.sendEmptyMessage(0);

                            btn_start.setText("정지");
                            btn_rec.setEnabled(true);

                            // 현재 상태를 RUN으로 변경
                            cur_status = RUN;
                            break;

                        case RUN:
                            // 핸들러 정지
                            myTimer.removeMessages(0);
                            myPauseTime = SystemClock.elapsedRealtime();

                            btn_start.setText("시작");
                            btn_rec.setText("리셋");

                            cur_status = PAUSE;
                            break;

                        case PAUSE:
                            long now = SystemClock.elapsedRealtime();

                            myTimer.sendEmptyMessage(0);

                            myBaseTime += (now - myPauseTime);

                            btn_start.setText("정지");
                            btn_rec.setText("기록");

                            cur_status = RUN;
                            break;
                    } // inner switch
                    break;

                case R.id.btn_rec:
                    switch ( cur_status ) {
                        case RUN:
                            String str = record.getText().toString();
                            str += String.format("%d. %s\n",
                                    myCount++, time_out.getText().toString());

                            // scrollView 안에 있는 record에 str을 갱신
                            record.setText(str);

                            // 최신 텍스트 위치로 스크롤을 갱신
                            scroll.scrollTo(0, record.getHeight());
                            break;

                        case PAUSE:
                            // 리셋
                            btn_rec.setText("기록");
                            btn_rec.setEnabled(false);
                            time_out.setText("00:00:00");
                            myCount = 1;
                            record.setText("");

                            cur_status = INIT;
                            break;
                    } // inner switch
                    break;

            } // switch

        } // onClick
    }; // click 이벤트 감지자의 끝

    // 화면갱신용 핸들러
    Handler myTimer = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            long now = SystemClock.elapsedRealtime();
            long resultTime = now - myBaseTime;

            // resultTime의 포멧을 지정(00:00:00)
            String viewTime = String.format(
                    "%02d:%02d:%02d",
                    resultTime/1000/60,
                    resultTime/1000%60,
                    resultTime%1000/10);

            time_out.setText(viewTime);

            // 1/1000초의 속도로 handleMessage 메소드를 반복수행
            myTimer.sendEmptyMessage(0);
        }
    };

}
package com.psc.ex_1214;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

    TextView txt;
    Button btn_add;
    String str = "";
    int cnt = 1;

    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        scroll = findViewById(R.id.scroll);
        txt = findViewById(R.id.txt);
        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str += cnt++ + "test\n";
                txt.setText(str);

                // 새로운 데이터가 추가될 때 마다 스크롤을 가장 아래쪽으로 이동
                scroll.scrollTo(0, txt.getHeight());
            }
        });

    } // onCreate()
}
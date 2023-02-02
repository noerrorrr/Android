package com.psc.ex_1220;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {

    Button btn_plus, btn_minus, btn_reset;
    TextView value;
    int num = 0;

    // DB를 사용하기에는 너무 작은 간단한 수준의 데이터들을 저장하기 위해
    // 사용하는 클래스. 이 클래스를 통해 저장하고자 하는 값을 앱 내부에
    // 물리적으로 저장할 수 있다.
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        // SharedPreferences객체 생성
        pref = getSharedPreferences("SHARE", MODE_PRIVATE);

        // pref에 저장된 값이 있다면 로드
        num = pref.getInt("save", 0);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_reset = findViewById(R.id.btn_reset);
        value = findViewById(R.id.value);

        // 불러온 값을 value에 세팅
        value.setText("" + num);

        btn_plus.setOnClickListener(click);
        btn_minus.setOnClickListener(click);
        btn_reset.setOnClickListener(click);

    } // onCreate()

    @Override
    protected void onStop() {
        super.onStop();
        // num값을 물리적으로 저장 해 보자!!
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("save", num);
        edit.commit(); // num의 값을 물리적으로 저장
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ) {

                case R.id.btn_plus:
                    num++;
                    break;

                case R.id.btn_minus:
                    num--;
                    break;

                case R.id.btn_reset:
                    num = 0;
                    break;

            } // switch

            value.setText( String.valueOf(num) );

        }
    };

}
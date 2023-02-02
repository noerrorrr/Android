package com.psc.ex_1214;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn_ok;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        btn_ok = findViewById(R.id.btn_ok);
        txt_result = findViewById(R.id.txt_result);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // et에 쓰여있는 값을 가져온다
                String ori = et.getText().toString(); // abc
                String rev = ""; // 원본 문자열을 뒤집어서 저장할 변수

                for ( int i = ori.length()-1; i >= 0; i-- ) {
                    rev += ori.charAt(i);
                }

                if ( ori.equals(rev) ) {
                    txt_result.setText( ori + "은(는) 회문수" );
                } else {
                    txt_result.setText( ori + "은(는) 안회문수" );
                }

            }
        });

    } // onCreate()
}
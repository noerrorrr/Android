package com.psc.ex_1214;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExampleActivity extends AppCompatActivity {

    EditText txt;
    Button btn_start;
    TextView result;
    String ori;
    String rev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        txt = findViewById(R.id.txt);
        btn_start = findViewById(R.id.btn_start);
        result = findViewById(R.id.result);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ori = "";
                rev = "";
                ori = txt.getText().toString();
                for ( int i = ori.length()-1; i >= 0; i-- ) {
                    rev += ori.charAt(i);
                }
                if ( ori.equals(rev) ) {
                    result.setText(ori + "(은)는 회문수 입니다");
                } else {
                    result.setText(ori + "(은)는 회문수가 아닙니다");
                }
            }
        });

    } // onCreate()
}
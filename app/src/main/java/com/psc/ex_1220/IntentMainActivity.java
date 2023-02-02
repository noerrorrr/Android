package com.psc.ex_1220;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class IntentMainActivity extends AppCompatActivity {

    EditText edit_name, edit_age, edit_phone, edit_bday;
    Button btn_date, btn_send;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        edit_phone = findViewById(R.id.edit_phone);
        edit_bday = findViewById(R.id.edit_bday);
        btn_date = findViewById(R.id.btn_date);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(sendListener);

        // 달력띄우기 버튼
        btn_date.setOnClickListener(dateListener);

    } // onCreate()

    View.OnClickListener dateListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 오늘날짜를 가져오자!
            Calendar now = Calendar.getInstance();
            int y = now.get(Calendar.YEAR); // 년
            int m = now.get(Calendar.MONTH); // 월
            int d = now.get(Calendar.DAY_OF_MONTH); // 일

            dialog = new DatePickerDialog(
                    IntentMainActivity.this,
                    dateSetListener,
                    y, m, d);

            dialog.show();
        }
    };

    // 달력의 날짜변경을 감지하는 감지자
    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int d) {

            // 파라미터 중 m은 1월 -> 0, 2월 -> 1.... (월은 배열식으로 들어온다)
            // 출력포멧 : 2022-04-22
            String str = String.format( "%d-%02d-%02d", y, m+1, d );
            edit_bday.setText(str);
        }
    };

    View.OnClickListener sendListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = edit_name.getText().toString();
            String age = edit_age.getText().toString();
            String tel = edit_phone.getText().toString();
            String birth = edit_bday.getText().toString();

            Intent intent = new Intent(
                    IntentMainActivity.this, IntentSubActivity.class );

            // Sub으로 전달하고자 하는 값을 intent에 저장
            intent.putExtra("m_name", name);
            intent.putExtra("m_age", age);
            intent.putExtra("m_tel", tel);
            intent.putExtra("m_birth", birth);

            startActivity(intent);

        }
    };

}
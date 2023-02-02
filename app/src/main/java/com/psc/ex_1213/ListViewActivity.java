package com.psc.ex_1213;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView myList;
    EditText et;
    Button btn_add;
    ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myList = findViewById(R.id.myList);
        et = findViewById(R.id.et);
        btn_add = findViewById(R.id.add);
        arr = new ArrayList<>();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // et에 입력되어 있는 값을 가지고 온다.
                String res = et.getText().toString();
                arr.add(res);

                MyAdapter adapter = new MyAdapter(
                        ListViewActivity.this,
                        R.layout.list_form,
                        arr,
                        myList);

                // 준비된 어댑터를 listView에 추가
                // setAdapter가 호출되면 Adapter클래스의 getView()가 실행
                myList.setAdapter(adapter);
            }
        });

    } // onCreate()
}
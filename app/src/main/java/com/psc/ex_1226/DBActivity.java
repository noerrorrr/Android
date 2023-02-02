package com.psc.ex_1226;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBActivity extends AppCompatActivity {

    SQLiteDatabase mDatabase;
    Button btn_all, btn_search, btn_insert, btn_del;
    EditText input_et;
    TextView result_txt;
    boolean isFirst;
    SharedPreferences pref;

    EditText name, phone, age;
    Button send;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        pref = getSharedPreferences("SHARE", MODE_PRIVATE);

        btn_all = findViewById(R.id.btn_all);
        btn_search = findViewById(R.id.btn_search);
        btn_insert = findViewById(R.id.btn_insert);
        btn_del = findViewById(R.id.btn_del);
        input_et = findViewById(R.id.input_et);
        result_txt = findViewById(R.id.result_txt);

        btn_all.setOnClickListener(click);
        btn_search.setOnClickListener(click);
        btn_insert.setOnClickListener(click);
        btn_del.setOnClickListener(click);

        load();
        // assets폴더의 myDB.db를 휴대폰 내부에 복사
        copyAssets();
        save(); // DB복사가 완료되었다면 저장

        // DB읽기
        mDatabase = openOrCreateDatabase(
                Environment.getExternalStorageDirectory()+"/database/myDB.db",
                Context.MODE_PRIVATE,
                null);

        // 테이블을 생성하고 컬럼을 추가하는 SQL문장을 넣어준다
        searchQuery("create table if not exists friend( name VARCHAR2(20), phone VARCHAR2(20), age NUMBER(3) );");

        // searchQuery("insert into friend values( 'hong', '0101111111', 20 );");
        // searchQuery("insert into friend values( 'kim', '0102221111', 30 );");
    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ) {
                case R.id.btn_all:
                    searchQuery("select * from friend");
                    break;

                case R.id.btn_search:
                    String str = input_et.getText().toString().trim();
                    if ( str.length() != 0 ) {

                        searchQuery("select * from friend where name=" + "'" + str + "'");

                    } else {
                        Toast.makeText(
                                DBActivity.this,
                                "한글자 이상 입력하세요",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.btn_del:
                    str = input_et.getText().toString().trim();
                    if ( str.length() != 0 ) {

                        searchQuery("delete from friend where name=" + "'" + str + "'");
                        btn_all.performClick();

                    } else {
                        Toast.makeText(
                                DBActivity.this,
                                "한글자 이상 입력하세요",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.btn_insert:
                    dialog = new Dialog(DBActivity.this, R.style.m_dialog);
                    dialog.setContentView(R.layout.dialog_form);
                    dialog.setTitle("친구추가");

                    name = dialog.findViewById(R.id.name);
                    phone = dialog.findViewById(R.id.phone);
                    age = dialog.findViewById(R.id.age);
                    send = dialog.findViewById(R.id.send);

                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ContentValues values = new ContentValues();
                            values.put("name", name.getText().toString());
                            values.put("phone", phone.getText().toString());
                            values.put("age", age.getText().toString());
                            mDatabase.insert("friend", null, values);

                            btn_all.performClick(); // DB갱신

                            dialog.dismiss(); // 다이얼로그 종료
                        }
                    });

                    dialog.show();
                    break;
            } // switch

        }
    };

    public void searchQuery( String query ) {
        Cursor c = mDatabase.rawQuery(query, null);

        String[] col = new String[c.getColumnCount()];
        col = c.getColumnNames();

        String[] str = new String[c.getColumnCount()];
        String result = ""; // 검색결과를 보여줄 String변수

        while( c.moveToNext() ) {

            for ( int i = 0; i < c.getColumnCount(); i++ ) {
                str[i] = "";
                str[i] += c.getString(i); // 각 컬럼별 데이터

                // 컬럼명 : 값 ( name : hong )
                result += col[i] + " : " + str[i] + "\n";
            } // for

            result += "\n";

        } // while

        result_txt.setText(result);

    }

    // assets폴더의 myDB.db를 휴대폰 내부에 복사
    public void copyAssets() {

        AssetManager assetManager = getAssets();
        String[] files = null;

        try {
            files = assetManager.list("");

            for ( int i = 0; i < files.length; i++ ) {
                Log.i("MY", files[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        OutputStream out = null;

        try {

            // myDB.db를 읽어 올 준비
            in = assetManager.open(files[1]);

            // 디바이스에 폴더 생성 및 복사
            String str = "" + Environment.getExternalStorageDirectory() + "/database";

            File mpath = new File(str);
            if (!mpath.exists()) {
                isFirst = true;
            }

            if (isFirst) {
                mpath.mkdirs(); // database라는 이름의 폴더를 절대경로에 생성

                out = new FileOutputStream(str + "/myDB.db");
                byte[] buffer = new byte[1024];

                try {
                    while (in.read(buffer) == -1) {
                        out.write(buffer);
                    }
                } catch (Exception e) {
                    Log.i("MY", "err:"+e.getMessage());
                }

                out.close();
                in.close();
                isFirst = false;

            }

        } catch (Exception e) {

        }

    } // copyAssets()

    public void save() {
        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean("save", isFirst);
        edit.commit();
    }

    public void load() {
        isFirst = pref.getBoolean("save", true);
    }

}
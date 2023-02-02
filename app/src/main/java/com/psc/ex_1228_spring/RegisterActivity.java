package com.psc.ex_1228_spring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    EditText edit_id, edit_pwd;
    Button btn_regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_id = findViewById(R.id.edit_id);
        edit_pwd = findViewById(R.id.edit_pwd);
        btn_regi = findViewById(R.id.btn_regi);

        // 회원가입을 위한 감지자
        btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // xxx.do?id=aaa&pwd=111
                String id = edit_id.getText().toString();
                String pwd = edit_pwd.getText().toString();

                // 서버로 전달할 파라미터
                String result = "id=" + id + "&pwd=" + pwd;

                new Task().execute(result, "type_regi");
            }
        });

    } // onCreate()

    // 회원가입을 위한 Async클래스
    class Task extends AsyncTask<String, Void, String> {

        String ip = "192.168.104.139"; // 서버의 ip번호
        String sendMsg, receiveMsg = ""; // 보내고 받을 내용을 저장할 변수
        String serverip = "http://" + ip + ":9090/android/regi.do";

        @Override
        protected String doInBackground(String... strings) {
            try {

                String str = "";
                // 접속할 서버 URL세팅
                URL url = new URL(serverip);

                // 서버 연결
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                // 서버로 파라미터 전달
                // xxx.do?id=aaa&pwd=111&type=type_regi
                sendMsg = strings[0] + "&type=" + strings[1];

                // 서버로 sendMsg보내기
                osw.write(sendMsg);
                osw.flush(); // 물리적으로 Stream의 변동사항을 저장
                osw.close();

                // 서버전송완료 후 처리된 결과값에 이상이 없을 때 이후 작업을 진행
                // "{res:[{'result':'success'}]}"
                if ( conn.getResponseCode() == conn.HTTP_OK ) {
                    // 서버로부터 넘겨받은 json형태의 결과값을 가져온다
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);

                    while ( (str = reader.readLine()) != null ) {
                        receiveMsg += str;
                    }
                }

                // {res:[{'result':'success'}]}받은 json구조를 풀어준다
                JSONArray jarray = new JSONObject(receiveMsg).getJSONArray("res");

                JSONObject jobject = jarray.getJSONObject(0);
                String result = jobject.optString("result");

                if ( result.equalsIgnoreCase("success") ) {
                    receiveMsg = "가입성공";
                }

            } catch (Exception e) {
                receiveMsg = "아이디가 중복됩니다";
            }

            return receiveMsg;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();

            if ( s.equals("가입성공") ) {
                // 가입 성공시 로그인 페이지로 전환
                Intent i = new Intent(
                        RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }
    } // Task class end

}
package com.yj.ex_1216;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btn_show = findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //간단한 경고창을 띄워 주는 AlertDialog를 생성
                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);

                dialog.setTitle("다이얼로그의 제목"); //제목
                dialog.setMessage("안녕하세요\n모두 반갑습니다"); //내용

                //다이얼로그에 버튼 추가 1 (제일 오른쪽 버튼)
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "버튼1",
                                Toast.LENGTH_SHORT).show();

                    }
                });

                //다이얼로그에 버튼 추가 2 (positive 버튼 오른쪽에 생성됨)
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "버튼2",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                //다이얼로그에 버튼 추가 (제일 왼쪽 버튼)
                //감지자 자리에 null을 넣으면 이벤트 처리 없이 다이얼로그만 종료
                dialog.setNeutralButton("later", null);

                //다이얼로그의 버튼을 클릭했을 때만 다이얼로그가 종료되도록 함 강제 종료를 막기 위해 사용
                //뒤로가기, 주변 터치로 다이얼로그가 종료되는 것을 방지
                //(false) 시 버튼 클릭 이외의 방법으로는 다이얼로그를 종료할 수 없음
                dialog.setCancelable(false);

                dialog.show(); //다이얼로그 호출(꼭 필요함)

            }
        });

    }//onCreate()

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); //강제로 종료되기에 super 코드는 사용하지 않음
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("앱 이름");
        dialog.setMessage("정말로 종료할까요?");

        dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish(); //현재 액티비티를 종료
            }
        });

        dialog.setNegativeButton("아니오", null);

        dialog.setCancelable(false);

        dialog.show();
    }
}











package com.psc.ex_1222;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    SweetAlertDialog sweetAlertDialog;
    Button btn_default, warning, error, success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_default = findViewById(R.id.btn_default);
        warning = findViewById(R.id.warning);
        error = findViewById(R.id.error);
        success = findViewById(R.id.success);

        btn_default.setOnClickListener(click);
        warning.setOnClickListener(click);
        error.setOnClickListener(click);
        success.setOnClickListener(click);

    } // onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch ( view.getId() ) {
                case R.id.btn_default:
                    sweetAlertDialog = new SweetAlertDialog(
                            MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
                    sweetAlertDialog.setCustomImage(R.mipmap.ic_launcher_round);
                    sweetAlertDialog.setTitleText("제목");
                    sweetAlertDialog.setContentText("기본창");
                    sweetAlertDialog.setConfirmText("확인");
                    sweetAlertDialog.setCancelText("취소");
                    sweetAlertDialog.setNeutralText("중립");
                    break;

                case R.id.warning:
                    sweetAlertDialog = new SweetAlertDialog(
                            MainActivity.this, SweetAlertDialog.WARNING_TYPE);
                    sweetAlertDialog.setTitleText("제목");
                    sweetAlertDialog.setContentText("경고창");
                    sweetAlertDialog.setConfirmText("확인");
                    sweetAlertDialog.setCancelText("취소");
                    sweetAlertDialog.setNeutralText("중립");

                    sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Toast.makeText(MainActivity.this,
                                    "경고창 확인", Toast.LENGTH_SHORT).show();
                            sweetAlertDialog.dismiss(); // 경고창 닫기
                        }
                    });

                    // 취소버튼 클릭시 이벤트 감지
                    sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Toast.makeText(MainActivity.this,
                                    "경고창 취소", Toast.LENGTH_SHORT).show();
                            sweetAlertDialog.dismiss(); // 경고창 닫기
                        }
                    });

                    break;

                case R.id.error:
                    sweetAlertDialog = new SweetAlertDialog(
                            MainActivity.this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog.setTitleText("제목");
                    sweetAlertDialog.setContentText("오류창");
                    sweetAlertDialog.setConfirmText("확인");
                    sweetAlertDialog.setCancelText("취소");
                    sweetAlertDialog.setNeutralText("중립");
                    break;

                case R.id.success:
                    sweetAlertDialog = new SweetAlertDialog(
                            MainActivity.this, SweetAlertDialog.SUCCESS_TYPE);
                    sweetAlertDialog.setTitleText("제목");
                    sweetAlertDialog.setContentText("성공창");
                    sweetAlertDialog.setConfirmText("확인");
                    sweetAlertDialog.setCancelText("취소");
                    sweetAlertDialog.setNeutralText("중립");
                    break;
            } // switch

            sweetAlertDialog.show();
        }
    };

}
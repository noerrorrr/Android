package com.yj.ex_1229;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ajalt.reprint.core.AuthenticationFailureReason;
import com.github.ajalt.reprint.core.AuthenticationListener;
import com.github.ajalt.reprint.core.Reprint;

public class FingerPrintActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        text = findViewById(R.id.text);

        //지문 사용을 위한 클래스 초기화 작업
        Reprint.initialize(this);

        if( checkDeviceSpec() ){
            //지문 사용이 가능한 경우
            Reprint.authenticate(new AuthenticationListener() {
                @Override
                public void onSuccess(int moduleTag) {
                    //인증에 성공한 경우
                    text.setText("인증 성공");

                    //Intent를 통해 지문 인식에 성공했을 때 전환할 페이지로 이동
                    //Intent... (써 주면 됨)
                }

                @Override
                public void onFailure(AuthenticationFailureReason failureReason, boolean fatal, CharSequence errorMessage, int moduleTag, int errorCode) {
                    //인증에 실패한 경우
                    text.setText("인증 실패 다시 시도하세요");
                }
            });

        }else {
            //지문 사용이 불가한 경우
            finish();
        }

    }//onCreate()

    //지문 인식을 지원하는 기기인지 확인
    public boolean checkDeviceSpec(){

        //true일 경우 디바이스에 지문 인식 센서가 존재한다는 의미
        boolean hardware = Reprint.isHardwarePresent();

        //true일 경우 기기에 미리 등록해 둔 지문이 있다는 의미
        boolean register = Reprint.hasFingerprintRegistered();

        if( !hardware ){
            Toast.makeText(this, "지문 인식을 지원하지 않는 기기입니다", Toast.LENGTH_SHORT).show();
        }

        if( !register ){
            Toast.makeText(this, "기기에 지문 등록을 먼저 해 주세요", Toast.LENGTH_SHORT).show();
        }

        return hardware && register;

    }

}








package com.yj.ex_1216;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class IntentMainActivity extends AppCompatActivity {

    Button btn_call, btn_sms, btn_camera, btn_gallery, btn_link, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        btn_call = findViewById(R.id.btn_call);
        btn_sms = findViewById(R.id.btn_sms);
        btn_camera = findViewById(R.id.btn_camera);
        btn_gallery = findViewById(R.id.btn_gallery);
        btn_link = findViewById(R.id.btn_link);
        btn_next = findViewById(R.id.btn_next);

        btn_call.setOnClickListener(click);
        btn_sms.setOnClickListener(click);
        btn_camera.setOnClickListener(click);
        btn_gallery.setOnClickListener(click);
        btn_link.setOnClickListener(click);
        btn_next.setOnClickListener(click);


    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ){

                case R.id.btn_call:
                    //다이얼 페이지로 전환
                    //Intent intent = new Intent(Intent.ACTION_DIAL);
                    //intent.setData(Uri.parse("tel:01011112222")); //tel: 전화하는 화면으로 전환(key 값 같은 느낌)
                    //startActivity(intent); //지정한 페이지로 화면을 전환

                    //즉시 전화를 걸어 주는 기능
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:01011112222")); //바로 전화를 걸어 줌
                    startActivity(intent);
                    break;

                case R.id.btn_sms:
                    //intent = new Intent(Intent.ACTION_SENDTO);
                    //intent.setData(Uri.parse("smsto:01012345678")); //smsto: 로 문자를 전송할 준비를 함

                    //보내고 싶은 내용이 있다면 함께 기입할 수 있음
                    //intent.putExtra("sms_body", "안녕"); //sms_body를 통해서 내가 쓰고 싶은 내용을 전달하기 직전까지 준비
                    //startActivity(intent);

                    try{
                        SmsManager sm = SmsManager.getDefault();
                        sm.sendTextMessage("0101112222", null,
                                            "이거 보내야지", null, null);
                    }catch (Exception e){

                    }
                    break;

                case R.id.btn_camera:
                    //카메라 페이지로 이동
                    //intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //startActivity(intent);

                    //동영상 페이지로 이동
                    intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                    startActivity(intent);
                    break;

                case R.id.btn_gallery:
                    //갤러리로 이동
                    intent = new Intent(Intent.ACTION_GET_CONTENT);

                    //갤러리로 가기 위해 반드시 설정해야 하는 타입
                    //intent.setType("image/*"); //이미지 타입만 전체 노출
                    //intent.setType("video/*"); //비디오 타입만 전체 노출
                    intent.setType("*/*"); //이미지, 영상 모두 노출

                    startActivity(intent);
                    break;

                case R.id.btn_link:
                    //웹 페이지로 화면 전환
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.naver.com")); //https: 홈페이지로 이동됨
                    startActivity(intent);
                    break;

                case R.id.btn_next:
                    intent = new Intent(IntentMainActivity.this,
                                        IntentSubActivity.class); //출발할 페이지와 도착할 페이지 지정
                    startActivity(intent);
                    break;

            }

        }
    };
}











package com.psc.ex_1226;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    boolean permissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("SHARE", MODE_PRIVATE);
        permissionGranted = pref.getBoolean("p", false);
        if ( permissionGranted ) {
            Intent intent = new Intent(MainActivity.this, DBActivity.class);
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            finish();
            startActivity(intent);
        }

        // 전화걸기 권한 수락여부
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            // 권한활성화
            setPermission();
            return;
        }

        // 연락처 접근 권한 수락여부
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            // 권한활성화
            setPermission();
            return;
        }

        // 내부저장소 접근 권한 수락여부
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            // 권한활성화
            setPermission();
            return;
        }

    } // onCreate()

    // 권한의 완료 및 미완료를 감지하는 감지자
    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            // 모든 권한이 수락되었을 경우
            // Intent를 통해서 메인화면으로 이동
            // Toast.makeText(MainActivity.this, "모든 권한이 수락됨", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor edit = pref.edit();
            permissionGranted = true;
            edit.putBoolean("p", permissionGranted);
            edit.commit();

            Intent intent = new Intent(
                    MainActivity.this, DBActivity.class);
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP);
            finish();
            startActivity(intent);
        }

        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {
            // 한가지라도 수락되지 않은 권한이 존재할 때
            Toast.makeText(MainActivity.this, "모든 권한이 수락되어야 합니다", Toast.LENGTH_SHORT).show();
            finish();
        }
    };

    // 수락되지 않은 권한을 찾아 수락하기
    public void setPermission() {
        SharedPreferences.Editor edit = pref.edit();
        permissionGranted = false;
        edit.putBoolean("p", permissionGranted);
        edit.commit();

        TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("이 앱에서 요구하는 모든 권한을 수락해주세요")
                .setPermissions(Manifest.permission.CALL_PHONE,
                                Manifest.permission.READ_CONTACTS,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }

}
package com.psc.ex_1214;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, /* this의 차이1 */
                        "ddd", Toast.LENGTH_SHORT).show();
            }
        });

    } // onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.my_menu, menu );
        return true;
    }

    // 어떤 메뉴가 클릭되었는지를 감지하는 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {

            case R.id.m1:
                Toast.makeText(this, /* this의 차이2 */
                        "추가 누름", Toast.LENGTH_SHORT).show();
                break;

            case R.id.m2:
                Toast.makeText(getApplicationContext(), /* this의 차이3 - Toast한정 this 대체 가능 */
                        "이메일 누름", Toast.LENGTH_SHORT).show();
                break;

            case R.id.m3:
                // 현재 보여지는 액티비티 한개를 종료
                finish();
                break;

        } // switch

        return true;
    }
}
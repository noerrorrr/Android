package com.yj.ex_1229;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;
    LinearLayout drawer;
    Button btn_open, btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout = findViewById(R.id.drawer_layout);
        drawer = findViewById(R.id.drawer);
        btn_open = findViewById(R.id.btn_open);
        btn_close = findViewById(R.id.btn_close);

        btn_open.setOnClickListener(click);
        btn_close.setOnClickListener(click);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ){

                case R.id.btn_open:
                    //서랍 열기
                    drawer_layout.openDrawer( drawer );
                    break;

                case R.id.btn_close:
                    drawer_layout.closeDrawer( drawer );
                    break;
            }//switch
        }
    };

}









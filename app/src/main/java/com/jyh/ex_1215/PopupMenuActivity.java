package com.jyh.ex_1215;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {

    Button show_btn, anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        anchor = findViewById(R.id.anchor);

        show_btn = findViewById(R.id.show_btn);
        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //팝업메뉴 클래스 생성
                PopupMenu popup = new PopupMenu(
                        PopupMenuActivity.this, anchor);//anchor : 팝업메뉴를 띄울 기준 객체

                //팝업 메뉴에게 my_menu.xml을 참조
                getMenuInflater().inflate( R.menu.my_menu, popup.getMenu() );

                //팝업메뉴에게 이벤트 감지자 등록
                popup.setOnMenuItemClickListener(p_click);

                popup.show();//메뉴보이기
            }
        });

    }//onCreate()

    PopupMenu.OnMenuItemClickListener p_click =
            new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch( menuItem.getItemId() ){

                case R.id.m1:
                    Toast.makeText(PopupMenuActivity.this, 
                            "메뉴1을 클릭함", Toast.LENGTH_SHORT).show();
                    break;

            }//switch

            return true;
        }
    };

}





















































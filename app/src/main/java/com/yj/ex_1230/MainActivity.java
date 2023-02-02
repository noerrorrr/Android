package com.yj.ex_1230;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

public class MainActivity extends FragmentActivity {

    ViewPager pager;
    Button menu1, menu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        menu1 = findViewById(R.id.menu1);
        menu2 = findViewById(R.id.menu2);
        menu1.setTag(0);
        menu2.setTag(1);

        //뷰페이저에 화면을 보여줄 어댑터를 세팅
        pager.setAdapter(new MyPagerAdapter( getSupportFragmentManager() ));

        //시작 페이지 지정 (따로 지정하지 않았을 때 기본은 0 인덱스부터 시작)
        pager.setCurrentItem(0);

        //버튼에 감지자 등록
        menu1.setOnClickListener(click);
        menu2.setOnClickListener(click);

        //밑줄을 그려 주는 인디케이터
        //UnderlinePageIndicator under_indicator = findViewById(R.id.under_indicator);
        //under_indicator.setViewPager(pager);
        //under_indicator.setFades(false);

        //원을 그려 주는 인디케이터
        CirclePageIndicator circlePageIndicator = findViewById(R.id.circle_indicator);
        circlePageIndicator.setViewPager(pager);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //클릭된 버튼에 부착된 태그값을 얻어 온다
            int tag = (int)view.getTag();
            pager.setCurrentItem(tag);

        }
    };

}













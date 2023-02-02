package com.yj.ex_1230;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        //현재 포커싱되어 있는 페이지를 처리
        PageFragment fragment = new PageFragment();
        fragment.setPosition(position);
        return fragment;
    }

    @Override
    public int getCount() {
        //사용할 페이지의 수를 결정하는 메서드
        return 5;
    }
}

package com.yj.ex_1230;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PageFragment extends Fragment {

    int position;

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout =
                (LinearLayout)inflater.inflate(R.layout.fragment_page, container, false);

        TextView text = layout.findViewById(R.id.text);
        text.setText( "page: " + position );

        if( position % 2 == 0 ){
            layout.setBackgroundColor(Color.parseColor("#aaaaff"));
        }

        return layout;

    }//onCreateView()
}
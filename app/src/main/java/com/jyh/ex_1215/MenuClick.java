package com.jyh.ex_1215;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuClick {

    public MenuClick(Context context) {
        Button show_btn = ((Activity)context).findViewById(R.id.show_btn);

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "버튼클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
















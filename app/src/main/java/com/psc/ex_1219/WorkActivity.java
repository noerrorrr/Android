package com.psc.ex_1219;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class WorkActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        img = findViewById(R.id.img);

    } // onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.work_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {

            case R.id.menu:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("제목");
                dialog.setMessage("내용");

                String str = "비활성";
                if ( img.getVisibility() == View.VISIBLE ) {
                    dialog.setPositiveButton(str, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            img.setVisibility(View.INVISIBLE);
                        }
                    });
                } else {
                    str = "활성";
                    dialog.setPositiveButton(str, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            img.setVisibility(View.VISIBLE);
                        }
                    });
                }

                dialog.show();
                break;

        } // switch

        return true;
    }
}
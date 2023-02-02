package com.psc.ex_1227;

import static com.psc.ex_1227.MainActivity.photo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class SubActivity extends AppCompatActivity {

    ImageView img;
    PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        img = findViewById(R.id.img);
        img.setImageDrawable( photo.getDrawable() );

        attacher = new PhotoViewAttacher(img);
        attacher.update();

    } // onCreate()
}
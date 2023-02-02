package com.psc.ex_1223;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SensorShakeActivity extends AppCompatActivity {

    LinearLayout linear;
    Button btn_x;
    SensorManager sensorManager;
    Sensor acc_sensor;

    int x, y, z;

    final int SHAKE_HOLD_1 = 18;
    final int SHAKE_HOLD_2 = -13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_shake);

        linear = findViewById(R.id.linear);
        btn_x = findViewById(R.id.btn_x);
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear.setVisibility(View.GONE);
            }
        });

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        acc_sensor = sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );

    } // onCreate()

    SensorEventListener sensorL = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            x = (int)sensorEvent.values[0];
            y = (int)sensorEvent.values[1];

            if ( x + y > SHAKE_HOLD_1 || x + y < SHAKE_HOLD_2 ) {
                linear.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    // 센서의 등록 및 해제
    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(
                sensorL, acc_sensor, SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(sensorL);

    }
}
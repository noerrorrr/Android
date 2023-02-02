package com.psc.ex_1223;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccSensorActivity extends AppCompatActivity {

    TextView txt_x, txt_y, txt_z;
    int x, y, z;

    // 센서 사용허가 및, 감지자의 등록 및 해지등을 감지
    SensorManager sensorManager;
    Sensor acc_sensor; // 가속도 센서가 될 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_sensor);

        txt_x = findViewById(R.id.txt_x);
        txt_y = findViewById(R.id.txt_y);
        txt_z = findViewById(R.id.txt_z);

        sensorManager = (SensorManager)getSystemService( SENSOR_SERVICE );

        // 가속도 센서
        acc_sensor = sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );

    } // onCreate()

    SensorEventListener sensorL = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            // 센서의 변경사항을 감지하는 메소드
            // x축 가속도 값
            x = (int)sensorEvent.values[0];

            // y축 가속도 값
            y = (int)sensorEvent.values[1];

            // z축 가속도 값
            z = (int)sensorEvent.values[2];

            txt_x.setText( "x : " + x );
            txt_y.setText( "y : " + y );
            txt_z.setText( "z : " + z );
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
            // 센서의 민감도가 변경되면 호출되는 메소드
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        // 다른 화면에서 현재 화면으로 전환되었을 때
        // 센서를 등록한다
        sensorManager.registerListener(
                sensorL, acc_sensor, SensorManager.SENSOR_DELAY_GAME);

        // 반응속도가 빠른 순
        // SENSOR_DELAY_FASTES
        // SENSOR_DELAY_GAME
        // SENSOR_DELAY_UI
        // SENSOR_DELAY_NORMAL
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 현재 액티비티에서 다른 화면으로 전환되었을 때
        // 등록된 센서를 제거한다
        sensorManager.unregisterListener( sensorL );
    }
}
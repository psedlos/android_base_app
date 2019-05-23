package com.example.mytestapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import de.nitri.gauge.Gauge;

public class DriverInterface extends BaseActivity {



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_interface);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Gauge gauge = findViewById(R.id.gauge);
        SensorManager sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor;
        sensor = sensorMgr.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        while (true) {
            gauge.moveToValue((float) sensor.getFifoReservedEventCount());
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }
}

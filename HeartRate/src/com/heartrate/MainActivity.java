package com.heartrate;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
	private Sensor mHeartRate;
	private TextView myHeartRate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myHeartRate = (TextView) this.findViewById(R.id.textHeartRate);

		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mHeartRate = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		myHeartRate.setText(Float.toString(event.values[0]));

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mHeartRate,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

}

package org.sensors2.common.dispatch;

import android.net.wifi.ScanResult;
import android.view.MotionEvent;

/**
 * Created by thomas on 03.11.14.
 */
public class Measurement {
	private final int sensorType;
	private final float[] values;
	private final String name;
	private final MeasurementType type;

	public Measurement(int sensorType, float[] values) {
		this.sensorType = sensorType;
		this.values = values;
		this.name = "";
		this.type = MeasurementType.Sensor;
	}

	public Measurement(ScanResult scanResult) {
		this.sensorType = 0;
		this.name = scanResult.SSID;
		this.values = new float[2];
		this.values[0] = scanResult.level;
		this.values[1] = scanResult.frequency;
		this.type = MeasurementType.Wifi;
	}

	public Measurement(MotionEvent motionEvent){
		this.sensorType = 0;
		this.name = "";
		this.values = new float[2];
		this.values[0] = motionEvent.getX();
		this.values[1] = motionEvent.getY();
		this.type = MeasurementType.Touch;
	}

	public float[] getValues() {
		return values;
	}

	public int getSensorType() {
		return sensorType;
	}

	public MeasurementType getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}

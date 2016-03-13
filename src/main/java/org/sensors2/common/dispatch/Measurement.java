package org.sensors2.common.dispatch;

import android.net.wifi.ScanResult;
import android.nfc.NdefMessage;
import android.os.Build;
import android.view.MotionEvent;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by thomas on 03.11.14.
 */
public class Measurement {
	private final int sensorType;
	private final float[] values;
	private final String name;
	private final MeasurementType type;

	public Measurement(int sensorType, float[] values, String name, MeasurementType type) {
		this.sensorType = sensorType;
		this.values = values;
		this.name = name;
		this.type = type;
	}

	public Measurement(int sensorType, float[] values) {
		this(sensorType, values, "", MeasurementType.Sensor);
	}

	public Measurement(NdefMessage msg) {
		this.sensorType = 0;
		this.values = new float[1];
//		this.values = new float[2];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
            this.values[0] = (float) getDec(msg.getRecords()[0].getId());
        } else {
            this.values[0] = 0.0F;
        }
//		this.values[1] = (float) getReversed(msg.getRecords()[0].getId());
		this.name = "";
		this.type = MeasurementType.Nfc;
	}

	public Measurement(ScanResult scanResult) {
		this.sensorType = 0;
        this.name = scanResult.SSID.replaceAll(" ", "-"); // the receiver can't have spaces
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

	public static int pointerIdToSensorType(int pointerId) {
		return pointerId * -1;
	}

	private static Measurement touchMeasurement(int pointerId, float x, float y) {
		int sensorType = pointerIdToSensorType(pointerId);
		float[] values = {x, y};
		return new Measurement(sensorType, values, "", MeasurementType.Touch);
	}

	// returns touch measurements with absolute screen coordinates
	public static List<Measurement> measurements(MotionEvent event) {
		return measurements(event, 1, 1);
	}

	// returns touch measurements with relative coordinates ( x/y values range from 0 to 1)
	public static List<Measurement> measurements(MotionEvent event, int width, int height) {
		if(width == 0 || height == 0) throw new IllegalArgumentException();

		List<Measurement> measurements = new LinkedList<>();

		int maskedAction = event.getActionMasked();

		switch (maskedAction) {
			case MotionEvent.ACTION_DOWN:
			case MotionEvent.ACTION_POINTER_DOWN:
			case MotionEvent.ACTION_MOVE: {
				for(int i = 0; i < event.getPointerCount(); i++) {
					int pointerId = event.getPointerId(i);
					float x = event.getX(i) / width;
					float y = event.getY(i) / height;
					measurements.add(touchMeasurement(pointerId, x, y));
				}
				break;
			}

			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_POINTER_UP:
			case MotionEvent.ACTION_CANCEL: {
				int pointerId = event.getPointerId(event.getActionIndex());
				measurements.add(touchMeasurement(pointerId, -1, -1));
				break;
			}
		}

		return measurements;
	}


	private String getHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = bytes.length - 1; i >= 0; --i) {
			int b = bytes[i] & 0xff;
			if (b < 0x10)
				sb.append('0');
			sb.append(Integer.toHexString(b));
			if (i > 0) {
				sb.append("-");
			}
		}
		return sb.toString();
	}

	private long getDec(byte[] bytes) {
		long result = 0;
		long factor = 1;
		for (int i = 0; i < bytes.length; ++i) {
			long value = bytes[i] & 0xffl;
			result += value * factor;
			factor *= 256l;
		}
		return result;
	}

	private long getReversed(byte[] bytes) {
		long result = 0;
		long factor = 1;
		for (int i = bytes.length - 1; i >= 0; --i) {
			long value = bytes[i] & 0xffl;
			result += value * factor;
			factor *= 256l;
		}
		return result;
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

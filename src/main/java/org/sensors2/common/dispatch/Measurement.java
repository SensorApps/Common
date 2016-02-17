package org.sensors2.common.dispatch;

import android.net.wifi.ScanResult;
import android.nfc.NdefMessage;
import android.os.Build;
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

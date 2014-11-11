package org.sensors2.common.sensors;

/**
 * Created by thomas on 03.11.14.
 */
public class Measurement {
	private final int sensorType;
	private final float[] values;

	public Measurement(int sensorType, float[] values) {
		this.sensorType = sensorType;
		this.values = values;
	}

	public float[] getValues() {
		return values;
	}

	public int getSensorType() {
		return sensorType;
	}
}

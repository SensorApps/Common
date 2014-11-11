package org.sensors2.common.sensors;

import android.content.SharedPreferences;

/**
 * Created by thomas on 05.11.14.
 */
public abstract class Settings {

	private float sensitivity;

	private int sensorRate;

	public Settings(SharedPreferences preferences) {
		this.setSensitivity(preferences);
		this.setSensorRate(preferences);
	}

	private void setSensitivity(SharedPreferences preferences) {
		this.sensitivity = Float.valueOf(preferences.getString("pref_general_sensitivity", "0"));
	}

	public void setSensorRate(SharedPreferences preferences) {
		this.sensorRate = Integer.valueOf(preferences.getString("pref_general_sensor_rate", "1"));
	}

	public int getSensorRate() {
		return sensorRate;
	}

	public float getSensitivity() {
		return sensitivity;
	}
}

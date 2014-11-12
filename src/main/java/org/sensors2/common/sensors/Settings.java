package org.sensors2.common.sensors;

import android.content.SharedPreferences;

/**
 * Created by thomas on 05.11.14.
 */
public abstract class Settings {


	private final int sensorRate;

	public Settings(SharedPreferences preferences) {
		this.sensorRate = this.setSensorRate(preferences);
	}

	public int setSensorRate(SharedPreferences preferences) {
		return Integer.valueOf(preferences.getString("pref_general_sensor_rate", "1"));
	}

	public int getSensorRate() {
		return sensorRate;
	}

}

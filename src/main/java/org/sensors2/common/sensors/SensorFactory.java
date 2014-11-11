package org.sensors2.common.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import java.util.List;

/**
 * Created by thomas on 05.11.14.
 */
public  class SensorFactory{

	private final SensorActivity activity;
	private DataDispatcher dispatcher;
	private List<Parameters> sensors;
	private Settings settings;
	private SensorManager sensorManager;

	public SensorFactory(SensorActivity activity){
		this.dispatcher = activity.getDispatcher();
		this.settings = activity.getSettings();
		this.sensorManager = activity.getSensorManager();
		this.activity = activity;
	}

	public void onPause() {
		this.sensorManager.unregisterListener(this.activity);
	}

	public void onResume() {
		for (Parameters sensor : this.sensors) {
			this.RegisterSensor(sensor);
		}
	}

	private void RegisterSensor(Parameters parameters) {
		if (parameters == null) {
			return;
		}
		Sensor sensor = this.sensorManager.getDefaultSensor(parameters.getSensorType());
		if (sensor == null) {
			return;
		}
		this.sensorManager.registerListener(this.activity, sensor, this.settings.getSensorRate());
	}

	public List<Parameters> getSensors() {
		if (sensors == null) {
			sensors = activity.GetSensors(sensorManager);
		}
		return sensors;
	}

	public void dispatch(SensorEvent sensorEvent) {
		this.dispatcher.dispatch(new Measurement(sensorEvent.sensor.getType(), sensorEvent.values));
	}
}

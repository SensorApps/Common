package org.sensors2.common.sensors;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import org.sensors2.common.dispatch.DataDispatcher;

import java.util.List;

/**
 * Created by thomas on 10.11.14.
 */
public interface SensorActivity extends SensorEventListener {
	List<Parameters> GetSensors(SensorManager manager);
	DataDispatcher getDispatcher();
	SensorManager getSensorManager();
	Settings getSettings();
}

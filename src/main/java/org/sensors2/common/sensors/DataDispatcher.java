package org.sensors2.common.sensors;

import org.sensors2.common.dispatch.Measurement;

/**
 * Created by thomas on 03.11.14.
 */
public interface DataDispatcher {
	void dispatch(Measurement sensorData);
}

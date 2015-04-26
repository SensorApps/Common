package org.sensors2.common.touch;

import android.view.View;

import org.sensors2.common.dispatch.DataDispatcher;

/**
 * Created by thomas on 04.04.15.
 */
public interface TouchActivity {
	DataDispatcher getDispatcher();
	View getTouchView();
}

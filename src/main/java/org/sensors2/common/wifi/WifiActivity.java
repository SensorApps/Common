package org.sensors2.common.wifi;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;

import org.sensors2.common.dispatch.DataDispatcher;

/**
 * Created by thomas on 15.03.15.
 */
public interface WifiActivity  {
	DataDispatcher getDispatcher();
	Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter);
	WifiManager getWifiManager();
}

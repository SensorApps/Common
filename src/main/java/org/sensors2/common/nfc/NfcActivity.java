package org.sensors2.common.nfc;

import android.content.Intent;
import android.nfc.NfcAdapter;

import org.sensors2.common.dispatch.DataDispatcher;

public interface NfcActivity {
    DataDispatcher getDispatcher();
    NfcAdapter getNfcAdapter();
    void handleIntent(Intent intent);
}

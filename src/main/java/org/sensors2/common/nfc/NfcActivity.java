package org.sensors2.common.nfc;

import android.content.Intent;
import android.nfc.NfcAdapter;

import org.sensors2.common.dispatch.DataDispatcher;

public interface NfcActivity {
    String MIME_TEXT_PLAIN = "text/plain";
    DataDispatcher getDispatcher();
    NfcAdapter getNfcAdapter();
}

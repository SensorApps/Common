package org.sensors2.common.nfc;


import android.nfc.NfcAdapter;
import android.os.Build;

public abstract class Parameters {

    private final boolean isEnabled;
    private final boolean isNdefPushEnabled;


    public Parameters(NfcAdapter nfcAdapter) {

        this.isEnabled = Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1 &&
                nfcAdapter.isEnabled();

        this.isNdefPushEnabled = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN &&
                nfcAdapter.isNdefPushEnabled();
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean isNdefPushEnabled() {
        return this.isNdefPushEnabled;
    }
}

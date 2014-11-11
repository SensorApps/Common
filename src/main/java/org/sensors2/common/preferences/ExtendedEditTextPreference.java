package org.sensors2.common.preferences;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

/**
 * Created by thomas on 03.11.14.
 */
public class ExtendedEditTextPreference extends EditTextPreference {
	public ExtendedEditTextPreference(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ExtendedEditTextPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ExtendedEditTextPreference(Context context) {
		super(context);
	}

	@Override
	public void setText(String text) {
		super.setText(text);
		setSummary(text);
	}
}

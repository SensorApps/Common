package org.sensors2.common.preferences;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

import org.sensors2.common.R;

/**
 * Created by thomas on 03.11.14.
 */
public class ExtendedListPreference extends ListPreference {

	private String summaryText;

	public ExtendedListPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		String namespace = "http://schemas.android.com/apk/res/android";
		String attribute = "summary";
		int resId = attrs.getAttributeResourceValue(namespace, attribute, 0);
		if (resId == 0) {
			this.summaryText = attrs.getAttributeValue(namespace, attribute);
		} else {
			this.summaryText = this.getContext().getResources().getString(resId);
		}

	}

	public ExtendedListPreference(Context context) {
		super(context);
	}

	@Override
	protected void onDialogClosed(boolean positiveResult) {
		super.onDialogClosed(positiveResult);
		if (positiveResult) {
			this.setSummary(this.getSummary());
		}
	}

	@Override
	public CharSequence getSummary() {
		int pos = this.findIndexOfValue(getValue());
		if (this.summaryText == null) {
			return this.getEntries()[pos];
		}
		return this.summaryText + System.getProperty("line.separator") + System.getProperty("line.separator")
				+ getContext().getResources().getString(R.string.current_value) + ": " + this.getEntries()[pos];
	}
}

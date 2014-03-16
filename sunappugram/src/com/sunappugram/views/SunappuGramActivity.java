package com.sunappugram.views;

import android.app.Activity;
import android.os.Bundle;

import com.parse.ParseAnalytics;
import com.sunappugram.R;

public class SunappuGramActivity extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
	}
}

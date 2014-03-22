package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;
import com.sunappugram.R;

public class DashboardActivity extends Activity {

	private TextView firstName, comment;
	private Button bLogout, bSettings, bComment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);


		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {

			firstName = (TextView) findViewById(R.id.dashboard_firstname);
			comment = (TextView) findViewById(R.id.comment_txtField);
			bLogout = (Button) findViewById(R.id.logout_button);
			bSettings = (Button) findViewById(R.id.settings_button);

//			Log.d("SunappuGram", currentUser.getString("firstName"));
			firstName.setText(", " + currentUser.getString("firstName"));

		} else {
			return;
		}

		setupListeners();
	}
	
	/**
	 * Sets up all OnClickListeners for all associated buttons
	 * */
	public void setupListeners() {
		//logout button on click listener
		bLogout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ParseUser.logOut();
				startActivity(new Intent(getApplicationContext(), SunappuGramActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});

		//settings button on click listener
		bSettings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});

		//comment button on click listener
		bComment.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//pop up some new window
			}
		});
	}

	/**
	 * This method has to be here so that user after logging out can not go back to dashboard.
	 * it is suppose to be just like this, @override.
	 */
	@Override
	public void onBackPressed() {
		return;
	}

}

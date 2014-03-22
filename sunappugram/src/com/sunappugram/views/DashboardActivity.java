package com.sunappugram.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.parse.ParseUser;
import com.sunappugram.R;

public class DashboardActivity extends Activity {

	private TextView firstName, lastName, email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {

			firstName = (TextView) findViewById(R.id.dashboard_firstname);
			lastName = (TextView) findViewById(R.id.dashboard_lastname);
			email = (TextView) findViewById(R.id.dashboard_email);

			firstName.setText(currentUser.getString("firstName"));
			lastName.setText(currentUser.getString("lastName"));
			email.setText(currentUser.getEmail());

		} else {
			return;
		}
	}

	public void onBackPressed() {
		return;
	}

}

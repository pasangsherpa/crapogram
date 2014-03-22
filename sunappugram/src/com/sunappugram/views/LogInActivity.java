package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.sunappugram.R;

public class LogInActivity extends Activity {
	private Button login;
	private EditText username, password;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		login = (Button) findViewById(R.id.button_login);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				username = (EditText) findViewById(R.id.username_login);
				password = (EditText) findViewById(R.id.password_login);

				validate();

				String name = username.getText().toString();
				String pw = password.getText().toString();

				//copy from parse website API.
				ParseUser.logInInBackground(name, pw, new LogInCallback() {
					public void done(ParseUser user, ParseException e) {
						if (user != null) {
							//i wanna go to dashboard after log in.
							Intent dashboard_intent = new Intent(getApplicationContext(), DashboardActivity.class);
							startActivity(dashboard_intent);
						} else {
							// Signup failed. Look at the ParseException to see what happened.
							Toast.makeText(getApplicationContext(), "cant log in", Toast.LENGTH_LONG).show();

						}
					}
				});

			}

		});

	}
	/**
	 * check if username or password is null, if either is, give a warning.
	 * @return true or false.
	 */
	private boolean validate() {
		//if user click log in, check if username and pw are matched or null.
		if(username == null || password == null) {
			Toast.makeText(getApplicationContext(), getString(R.string.signup_warning), Toast.LENGTH_LONG).show();

			return false;
		}

		return true;
	}
}

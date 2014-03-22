package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.sunappugram.R;

public class SignUpActivity extends Activity {

	private Button signUp;
	private EditText firstName, lastName, email, password;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		signUp = (Button) findViewById(R.id.signup_button);
		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				firstName = (EditText) findViewById(R.id.signup_firstname);
				lastName = (EditText) findViewById(R.id.signup_lastname);
				email = (EditText) findViewById(R.id.signup_email);
				password = (EditText) findViewById(R.id.signup_password);

				validate();
				Log.d("sunappugram", email.getText().toString());//the output test, debugging like println

				ParseUser newUser = new ParseUser();
				newUser.setUsername(email.getText().toString());
				newUser.put("firstName", firstName.getText().toString()); //firstName column from Parse database
				newUser.put("lastName", lastName.getText().toString());
				newUser.setEmail(email.getText().toString());
				
				newUser.setPassword(password.getText().toString());

				newUser.signUpInBackground(new SignUpCallback() {
					public void done(ParseException e) {
						if (e == null) {
							Toast.makeText(getApplicationContext(),
									"User signed up", Toast.LENGTH_LONG).show();
							Intent dashboard_intent = new Intent(getApplicationContext(), DashboardActivity.class);
							startActivity(dashboard_intent);
							overridePendingTransition(R.anim.right_slide_out, R.anim.right_slide_in);
							
						} else {
							Toast.makeText(getApplicationContext(),
									"something went wrong", Toast.LENGTH_LONG)
									.show();
						}
					}
				});

			}
		});

	}

	private boolean validate() {
		if (firstName == null || lastName == null || email == null
				|| password == null || firstName.length() < 2
				|| lastName.length() < 2 || email.length() < 2
				|| password.length() < 6) {
			Toast.makeText(getApplicationContext(),
					getString(R.string.signup_warning), Toast.LENGTH_LONG)
					.show();
			return false;
		}
		return true;
	}

}

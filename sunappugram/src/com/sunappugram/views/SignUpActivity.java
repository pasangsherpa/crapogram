package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.sunappugram.R;

public class SignUpActivity extends Activity {
	private LinearLayout signupContainer;
	private Button signUp;
	private EditText firstName, lastName, email, password;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);


		//set opacity.
		signupContainer = (LinearLayout) findViewById(R.id.signup_container);
		signupContainer.getBackground().setAlpha(100);

		//SignUp button and listener.
		signUp = (Button) findViewById(R.id.signup_button);
		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("Sunnapugram", "HELLO WORLD");

				firstName = (EditText) findViewById(R.id.signup_firstname);
				lastName = (EditText) findViewById(R.id.signup_lastname);
				email = (EditText) findViewById(R.id.signup_email);
				password = (EditText) findViewById(R.id.signup_password);

				if (!validate()) {
					Log.d("Sunappugram", "Validation failed");//the output test, debugging like println
					
					return;
				}

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
							//intent is to open dashboard activity.
							Intent dashboard_intent = new Intent(getApplicationContext(), DashboardActivity.class);
							startActivity(dashboard_intent);
							overridePendingTransition(R.anim.right_slide_out, R.anim.right_slide_in);

						} else {
							Toast.makeText(getApplicationContext(),
									"Something went wrong", Toast.LENGTH_LONG)
									.show();
						}
					}
				});

			}
		});

	}

	private boolean validate() {
		if (firstName == null || lastName == null || email == null
				|| password.getText() == null || firstName.getText().length() < 2
				|| lastName.getText().length() < 2 || email.getText().length() < 2
				|| password.getText().length() < 6) {
			Toast.makeText(getApplicationContext(),
					getString(R.string.signup_warning), Toast.LENGTH_LONG)
					.show();
			return false;
		}
		else {
			return true;
		}
	}

}

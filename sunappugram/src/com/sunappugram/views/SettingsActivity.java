package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.sunappugram.R;

public class SettingsActivity extends Activity {

	private Button update;
	private EditText firstName,lastName, email, password, userName;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		firstName = (EditText) findViewById(R.id.firstNameEditText);
		lastName =  (EditText) findViewById(R.id.lastNameEditText);  
		password = (EditText) findViewById(R.id.passwordEditText);
		userName =  (EditText) findViewById(R.id.userNameEditText);
		update = (Button) findViewById(R.id.updateButton);
		validate();
		update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ParseUser currentUser = ParseUser.getCurrentUser();
				if (currentUser != null) {
					firstName.setText(currentUser.getString("firstName"));
					lastName.setText(currentUser.getString("lastName"));
					password.setText(currentUser.getString("password"));
					userName.setText(currentUser.getString("userName"));
					email.setText(currentUser.getEmail());
					startActivity(new Intent(getApplicationContext(), LogInActivity.class));

				} else {
					return;
				}		
			}
		});
	}
	private boolean validate() {
		if (firstName == null || lastName == null || email == null || userName == null
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

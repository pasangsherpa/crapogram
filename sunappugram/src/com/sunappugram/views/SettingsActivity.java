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
	private EditText name, email, password,userName;
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		name = (EditText) findViewById(R.id.user_name_view);
		email = (EditText) findViewById(R.id.editText2);
		password = (EditText) findViewById(R.id.editText3);
		userName =  (EditText) findViewById(R.id.editText1);
		update = (Button) findViewById(R.id.Button03);
		validate();
		update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ParseUser currentUser = ParseUser.getCurrentUser();
				if (currentUser != null) {
					name.setText(currentUser.getString("firstName"));
					password.setText(currentUser.getString("password"));
					email.setText(currentUser.getEmail());
					startActivity(new Intent(getApplicationContext(), LogInActivity.class));

				} else {
					return;
				}		
			}
		});
	}
	private boolean validate() {
		if (name == null || email == null || userName == null
				|| password == null || name.length() < 2
				|| email.length() < 2
				|| password.length() < 6) {
			Toast.makeText(getApplicationContext(),
					getString(R.string.signup_warning), Toast.LENGTH_LONG)
					.show();
			return false;
		}
		return true;
	}
}

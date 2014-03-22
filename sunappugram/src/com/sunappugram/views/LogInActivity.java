package com.sunappugram.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
				
				ParseUser currentUser = new ParseUser();
				
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


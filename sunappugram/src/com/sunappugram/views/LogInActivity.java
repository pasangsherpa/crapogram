package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.sunappugram.R;

public class LogInActivity extends Activity {
	private Button login, cancel, retrieve;
	private EditText username, password;
	private AbsoluteLayout loginContainer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//set opacity.
		loginContainer = (AbsoluteLayout) findViewById(R.id.login_container);
		loginContainer.getBackground().setAlpha(100);

		login = (Button) findViewById(R.id.button_login);
		cancel = (Button) findViewById(R.id.button_cancel);
		retrieve = (Button) findViewById(R.id.retrieve);
		
		
		cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), SunappuGramActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
			
		}); 
	
		
		
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				username = (EditText) findViewById(R.id.username_login);
				password = (EditText) findViewById(R.id.password_login);

				validate();

				String name = username.getText().toString();
				String pw = password.getText().toString();

				//copy from parse website Android/API/ User.
				ParseUser.logInInBackground(name, pw, new LogInCallback() {
					public void done(ParseUser user, ParseException e) {
						if (user != null) {
							//i wanna go to dashboard after log in.
							Intent dashboard_intent = new Intent(getApplicationContext(), DashboardActivity.class);
							startActivity(dashboard_intent);
						} else {
							// Signup failed. Look at the ParseException to see what happened.
							Toast.makeText(getApplicationContext(), e.getCode() + "", Toast.LENGTH_LONG).show();
						}
					}
				});
			}
		});
		retrieve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent reset_password = new Intent(getApplicationContext(), ResetPasswordActivity.class);
				startActivity(reset_password);
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


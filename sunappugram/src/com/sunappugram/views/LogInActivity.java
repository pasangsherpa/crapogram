package com.sunappugram.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

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
				
			}
		});

	}

}


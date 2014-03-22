package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.parse.ParseAnalytics;
import com.sunappugram.R;

public class SunappuGramActivity extends Activity {
	private Button login, reg;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		login = (Button) findViewById(R.id.loginButton);
		login.setOnClickListener(new OnClickListener() {
/**
 * Click on the LogIn button in the Main view, got o login view to fill out username/email and password.
 */
			@Override
			public void onClick(View v) {
				Intent login_intent = new Intent(getApplicationContext(),
						LogInActivity.class);
				startActivity(login_intent);
				overridePendingTransition(R.anim.right_slide_in,
						R.anim.right_slide_out);
			}
		});

		reg = (Button) findViewById(R.id.registerButton);
		reg.setOnClickListener(new OnClickListener() {
/**
 * Click on the Register button, go to Register view.
 */
			@Override
			public void onClick(View v) {
				Intent reg_intent1 = new Intent(getApplicationContext(), SignUpActivity.class);
				startActivity(reg_intent1);
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});
	}

}

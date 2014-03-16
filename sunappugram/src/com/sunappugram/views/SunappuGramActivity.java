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
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent login_intent = new Intent(getApplicationContext(), LogInActivity.class);
			startActivity(login_intent);
			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});
		
		
		reg = (Button) findViewById(R.id.registerButton);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent login_intent1 = new Intent(getApplicationContext(), Register.class);
			startActivity(login_intent1);
			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});
	}
	
}

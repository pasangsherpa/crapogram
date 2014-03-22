package com.sunappugram.views;

import javax.security.auth.callback.Callback;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import com.sunappugram.R;

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

public class ResetPasswordActivity extends Activity {
	private Button cont, cancel;
	private EditText email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_password);

		cont = (Button) findViewById(R.id.continue_button);
		cancel = (Button) findViewById(R.id.cancel_button);
		email = (EditText) findViewById(R.id.emailAddress);

		cont.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.d("ResetActivity", "test");
				// TODO Auto-generated method stub
				ParseUser.requestPasswordResetInBackground(email.getText()
						.toString().trim(), new RequestPasswordResetCallback() {
					@SuppressWarnings("unused")
					public void done(ParseUser user, ParseException e) {
						if (user != null) {

							Toast.makeText(getApplicationContext(),
									"Check your Email address!",
									Toast.LENGTH_LONG).show();
							startActivity(new Intent(getApplicationContext(),
									LogInActivity.class));
						} else {

							Toast.makeText(getApplicationContext(),
									e.getCode() + "", Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void done(ParseException e) {
						// TODO Auto-generated method stub

					}
				});

			}

		});

		ParseUser.requestPasswordResetInBackground(email.getText().toString(),
				new RequestPasswordResetCallback() {
					@SuppressWarnings("unused")
					public void done(ParseUser user, ParseException e) {
						if (user != null) {

							Toast.makeText(getApplicationContext(),
									"Check your Email address!",
									Toast.LENGTH_LONG).show();
							startActivity(new Intent(getApplicationContext(),
									LogInActivity.class));
						} else {

							Toast.makeText(getApplicationContext(),
									e.getCode() + "", Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void done(ParseException e) {
						// TODO Auto-generated method stub

					}
				});

	}

	public void onBackPressed() {
		return;
	}

}

package com.sunappugram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

public class SunappuGram extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		  Parse.initialize(this, "B6JiY65Rydt4lUIhxywPdBlW0st6bFDvhs8a1GDt", "9JGgUGe0WZwpiB9E32qFnsgEWv7RggGPM7XGXQO1");

		ParseUser.enableAutomaticUser();

	}

}

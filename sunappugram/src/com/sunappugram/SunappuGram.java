package com.sunappugram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

public class SunappuGram extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "m7etrf98wPegyxE9o95X7a1DDhXEITYq5qMEOyNs",
				"igd4TsaPsyjwlhXgl4xWoXfm5b6gccUwutI0U6m6");

		ParseUser.enableAutomaticUser();

	}

}

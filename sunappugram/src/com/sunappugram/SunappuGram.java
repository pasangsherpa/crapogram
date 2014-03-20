package com.sunappugram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

public class SunappuGram extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		  Parse.initialize(this, "hl7Imp1b54RPz4vUTAvgnDDDTIRQSv01m5jKKPJJ", "WceKZvnslF7RpO1eaNO6KnEXCa1JRoYAwYyYQ5Ah");

		ParseUser.enableAutomaticUser();

	}

}

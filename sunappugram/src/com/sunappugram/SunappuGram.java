package com.sunappugram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

public class SunappuGram extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		  Parse.initialize(this, "y6IjnJUmL7AGRiCDld2o6Si8MfyW1mjWDsITYHxh", "UpyQG0fglJLcxRdCVpTZstZco2L4wipGgV6bmsoS");


		ParseUser.enableAutomaticUser();

	}

}

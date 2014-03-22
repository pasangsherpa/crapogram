package com.sunappugram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

public class SunappuGram extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
<<<<<<< HEAD
		  Parse.initialize(this, "y6IjnJUmL7AGRiCDld2o6Si8MfyW1mjWDsITYHxh", "UpyQG0fglJLcxRdCVpTZstZco2L4wipGgV6bmsoS");

=======
		  Parse.initialize(this, "B6JiY65Rydt4lUIhxywPdBlW0st6bFDvhs8a1GDt", "9JGgUGe0WZwpiB9E32qFnsgEWv7RggGPM7XGXQO1");
>>>>>>> 2a2836296349637f94b3ee7ecd6161f869457afc

		ParseUser.enableAutomaticUser();

	}

}

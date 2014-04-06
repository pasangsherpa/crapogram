package com.sunappugram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.sunappugram.models.Comment;
import com.sunappugram.models.Post;
import com.sunappugram.models.User;

public class SunappuGram extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// Add your initialization code here
		Parse.initialize(this, "B6JiY65Rydt4lUIhxywPdBlW0st6bFDvhs8a1GDt", "9JGgUGe0WZwpiB9E32qFnsgEWv7RggGPM7XGXQO1");
		ParseUser.enableAutomaticUser();
		ParseObject.registerSubclass(Comment.class);
		ParseObject.registerSubclass(Post.class);
		ParseObject.registerSubclass(User.class);
	}

}

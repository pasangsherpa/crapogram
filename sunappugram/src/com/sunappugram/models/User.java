package com.sunappugram.models;

import com.parse.ParseClassName;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseUser {

	public String getId() {
		return getString("objectId");
	}

	public String getUsername() {
		return getString("username");
	}

}
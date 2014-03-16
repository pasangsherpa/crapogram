package com.sunappugram.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("User")
public class User extends ParseObject {

	public String id() {
		return getString("objectId");
	}

	public String username() {
		return getString("username");
	}

	
}
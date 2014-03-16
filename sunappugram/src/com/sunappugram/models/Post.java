package com.sunappugram.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Post")
public class Post extends ParseObject{

	public static ParseQuery<Post> getQuery() {
		return ParseQuery.getQuery(Post.class);
	}
	
}

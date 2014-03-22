package com.sunappugram.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Comment")
public class Comment extends ParseObject {

	public String getComment() {
		return getString("comment");
	}
	
	public static ParseQuery<Comment> getQuery() {
		return ParseQuery.getQuery(Comment.class);
	}
}

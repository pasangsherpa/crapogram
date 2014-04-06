package com.sunappugram.views;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.sunappugram.R;
import com.sunappugram.models.Comment;

public class DashboardActivity extends Activity {

	private TextView tFirstName, tComment;
	private ListView postsList;
	private Button bLogout, bSettings, bPost;
	private LinearLayout dashboardContainer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		
		//set opacity.
		dashboardContainer = (LinearLayout) findViewById(R.id.dashboard_container);
		dashboardContainer.getBackground().setAlpha(100);
		
		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {
			tFirstName = (TextView) findViewById(R.id.dashboard_firstname);
			tComment = (TextView) findViewById(R.id.comment_txtField);
			bLogout = (Button) findViewById(R.id.logout_button);
			bSettings = (Button) findViewById(R.id.settings_button);
			bPost = (Button) findViewById(R.id.post_button);
			postsList = (ListView) findViewById(R.id.posts_list);
//			Log.d("SunappuGram", currentUser.getString("firstName"));
			tFirstName.setText(", " + currentUser.getString("firstName"));
		} else {
			return;
		}
		setupListeners();
		initializeDashBoardUI();
	}
	
	private void initializeDashBoardUI() {
		ParseQuery<Comment> test = Comment.getQuery();

		test.findInBackground(new FindCallback<Comment>() {
			@Override
			public void done(List<Comment> comments, ParseException e) {
				//update UI by whatever new comment was posted
				postsList.setAdapter(new PostsAdapter(getApplicationContext(), comments));
			}
		});
	}

	/**
	 * Sets up all OnClickListeners for all associated buttons
	 * */
	private void setupListeners() {
		//logout button on click listener
		bLogout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ParseUser.logOut();
				startActivity(new Intent(getApplicationContext(), SunappuGramActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});

		//settings button on click listener
		bSettings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});
		
		bPost.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Create a Comment Object from Parse and Post comment
				//on database
				Comment newComment = new Comment();
				newComment.put("comment", tComment.getText().toString());
				newComment.saveInBackground();
			}
		});
	}

	/**
	 * This method has to be here so that user after logging out can not go back to dashboard.
	 * it is suppose to be just like this, @override.
	 */
	@Override
	public void onBackPressed() {
		return;
	}
	
	private class PostsAdapter extends ArrayAdapter<Comment>{
		private final Context my_context;
		private final List<Comment> my_values;
		public PostsAdapter(final Context the_context, final List<Comment> the_values) {
			super(the_context, R.layout.placeholder, the_values);
			my_context = the_context;
			my_values = the_values;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = 
					(LayoutInflater) my_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.placeholder, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.textplaceholder);
			textView.setText(my_values.get(position).getString("comment"));

			return rowView;
		}
	}

}

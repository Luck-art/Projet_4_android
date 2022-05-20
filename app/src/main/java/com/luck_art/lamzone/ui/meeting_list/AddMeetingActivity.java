package com.luck_art.lamzone.ui.meeting_list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.luck_art.lamzone.R;
import com.luck_art.lamzone.di.DI;
import com.luck_art.lamzone.model.Meeting;
import com.luck_art.lamzone.service.MeetingApiService;


public class AddMeetingActivity extends AppCompatActivity {

		TextInputEditText place;
		TextInputEditText hour;
		TextInputEditText topic;
		TextInputEditText mail;
		MaterialButton register_meeting;

		private MeetingApiService mApiService;

		@SuppressLint("WrongViewCast")
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.create_meeting);

			place = findViewById(R.id.place);
			hour = findViewById(R.id.hour);
			topic = findViewById(R.id.topic);
			mail = findViewById(R.id.mail);
			register_meeting = findViewById(R.id.register_meeting);

			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			mApiService = DI.getMeetingApiService();

			register_meeting.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					addMeeting();
				}
			});


		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
				case android.R.id.home : {
					finish();
					return true;
				}
			}
			return super.onOptionsItemSelected(item);
		}

		void addMeeting() {
			Meeting meeting = new Meeting(
					System.currentTimeMillis(),
					place.getText().toString(),
					hour.getText().toString(),
					topic.getText().toString(),
					mail.getText().toString()
			);
			mApiService.createMeeting(meeting);
			finish();
		}

		/**
		 * Generate a random image. Useful to mock image picker
		 * @return String
		 */

		/**
		 * Used to navigate to this activity
		 * @param activity
		 */
		public static void navigate(FragmentActivity activity) {
			Intent intent = new Intent(activity, AddMeetingActivity.class);
			ActivityCompat.startActivity(activity, intent, null);
		}

}



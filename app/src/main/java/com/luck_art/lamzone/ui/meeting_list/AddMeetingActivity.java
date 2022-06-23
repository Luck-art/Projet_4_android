package com.luck_art.lamzone.ui.meeting_list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.luck_art.lamzone.R;
import com.luck_art.lamzone.di.DI;
import com.luck_art.lamzone.model.Meeting;
import com.luck_art.lamzone.service.MeetingApiService;

import java.util.ArrayList;
import java.util.List;


public class AddMeetingActivity extends AppCompatActivity {

	public static final  String EXTRA_MESSAGE = "com.luck_art.lamzone.ui.meeting_list.MESSAGE";

		Spinner place;
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

			List<String> NamePlace = new ArrayList<String>();
			NamePlace.add("Mario");
			NamePlace.add("Luigi");
			NamePlace.add("Warrio");

			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
					android.R.layout.simple_spinner_item, NamePlace);
// Specify the layout to use when the list of choices appears
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
			place.setAdapter(adapter);

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
			String hour = this.hour.getText().toString().trim();
			int hourInt = Integer.parseInt(hour);
			if (hourInt < 8 || hourInt > 20) {
				Snackbar.make(this.hour, "Veuillez entrer une heure entre 8h00 et 12h00 ou entre 14h00 et 20h00", Snackbar.LENGTH_LONG).show();
				return;
			} else if (hour.equals("")) {
				Snackbar.make(this.hour, "Veuillez mentionner une heure pour votre réunion", Snackbar.LENGTH_LONG).show();
				return;
			}
			String place = this.place.getSelectedItem().toString().trim();
			if (place.equals("")) {
				Snackbar.make(this.place, "Veuillez mentionner un lieu pour votre réunion", Snackbar.LENGTH_LONG).show();
				return;
			}
			String topic = this.topic.getText().toString().trim();
			if (topic.equals("")) {
				Snackbar.make(this.topic, "Veuillez mentionner un sujet pour votre réunion", Snackbar.LENGTH_LONG).show();
				return;
			}
			String mail = this.mail.getText().toString().trim();
			if (mail.equals("")) {
				Snackbar.make(this.mail, "Veuillez mentionner une/des adresse(s) mail(s) pour votre réunion", Snackbar.LENGTH_LONG).show();
				return;
			}
			Meeting meeting = new Meeting(
					System.currentTimeMillis(),
					place,
					hour,
					topic,
					mail
			);
			boolean succesMeetingCreation = mApiService.createMeeting(meeting);
			if (succesMeetingCreation) {
				finish();
			} else {
				Snackbar.make(this.place, "Cette salle n'est pas disponible pour cette heure", Snackbar.LENGTH_LONG).show();
			}

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



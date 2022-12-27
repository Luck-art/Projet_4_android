package com.luck_art.lamzone.utils.meeting_list;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.luck_art.lamzone.R;
import com.luck_art.lamzone.di.DI;
import com.luck_art.lamzone.model.Meeting;
import com.luck_art.lamzone.service.MeetingApiService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class AddMeetingActivity extends AppCompatActivity {

		Spinner duration;
		Spinner place;
		TextView date;
		TextInputEditText topic;
		TextInputEditText mail;
		MaterialButton register_meeting;

		private MeetingApiService mApiService;


		View boutonSaveEmail;
		LinearLayout emailsGroup;

		private List<String> emailsEntrees = new ArrayList<>();
		private Date meetingTime;
		private Duration meetingDuration;

	@SuppressLint("WrongViewCast")
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.create_meeting);

			place = findViewById(R.id.spinnerPlace);
			date = findViewById(R.id.buttonHour);
			duration = findViewById(R.id.spinnerDuration);
			topic = findViewById(R.id.topic);
			mail = findViewById(R.id.mail);
			register_meeting = findViewById(R.id.register_meeting);
			boutonSaveEmail = findViewById(R.id.saveEmail);
			emailsGroup = findViewById(R.id.emailsList);

			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			mApiService = DI.getMeetingApiService();
			date.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					askDate();
				}
			});

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


		// Place ArrayAdapter
		ArrayAdapter<CharSequence> adapterPlace = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, NamePlace);
		adapterPlace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		place.setAdapter(adapterPlace);

		List<String> NameDuration = new ArrayList<String>();
		NameDuration.add("15 min");
		NameDuration.add("30 min");
		NameDuration.add("45 min");
		NameDuration.add("60 min");

		// Duration ArrayAdapter
		ArrayAdapter<CharSequence> adapterDuration = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, NameDuration);
		adapterDuration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		duration.setAdapter(adapterDuration);


			boutonSaveEmail.setOnClickListener(new View.OnClickListener() {


				private View textMail;

				@Override
				public void onClick(View view) {
					final String textMail = mail.getText().toString();
					if (textMail.isEmpty()) {
						return;
					}
					emailsEntrees.add(textMail);
					//puis je remet a 0 le champ email pour enlever le texte présent
					mail.getText().clear();

					Chip chip = new Chip(AddMeetingActivity.this);
					chip.setText(textMail);
					emailsGroup.addView(chip);
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

	private void askDate() {
		Calendar now = Calendar.getInstance();

		new DatePickerDialog(AddMeetingActivity.this, 0, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
				askTime(year, month, dayOfMonth);
			}
		}, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)).show();
	}

	private void askTime(int year, int month, int dayOfMonth) {
		new TimePickerDialog(AddMeetingActivity.this, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, year);
				calendar.set(Calendar.MONTH, month);
				calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
				calendar.set(Calendar.MINUTE, minute);

				meetingTime = calendar.getTime();

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'à' hh:mm");
				String formatted = formatter.format(meetingTime);
				date.setText(formatted);
			}
		}, 12, 00, true).show();
	}

		void addMeeting() {

			if (meetingTime == null) {
				Snackbar.make(this.date, "Veuillez mentionner une heure pour votre réunion", Snackbar.LENGTH_LONG).show();
				return;
			}
			String meetingDuration = this.duration.getSelectedItem().toString().trim();
			if (duration.equals("")) {
				Snackbar.make(this.duration, "Veuillez mentionner une durée pour votre réunion", Snackbar.LENGTH_LONG).show();
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

			if (emailsEntrees.isEmpty()) {
				Snackbar.make(this.topic, "Veuillez mentionner une/des adresse(s) mail(s) pour votre réunion", Snackbar.LENGTH_LONG).show();
				return;
			}
			Meeting meeting = new Meeting(
					System.currentTimeMillis(),
					place,
					topic,
					emailsEntrees,
					meetingTime,
					Integer.parseInt(meetingDuration.replace(" min", ""))
			);
			boolean succesMeetingCreation = mApiService.createMeeting(meeting);
			if (succesMeetingCreation) {
				finish();
			} else {
				Snackbar.make(this.place, "Cette salle n'est pas disponible pour cette heure", Snackbar.LENGTH_LONG).show();
			}

		}

}



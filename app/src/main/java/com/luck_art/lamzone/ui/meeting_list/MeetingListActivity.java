package com.luck_art.lamzone.ui.meeting_list;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luck_art.lamzone.R;
import com.luck_art.lamzone.di.DI;
import com.luck_art.lamzone.model.Meeting;
import com.luck_art.lamzone.service.MeetingApiService;

import java.util.ArrayList;
import java.util.List;

// Crétion de l'interface d'écoute du clic



public class MeetingListActivity extends AppCompatActivity {


	RecyclerView list;
	View buttonAddMeeting;

	// Filtre des salles

	String namePlaceFilter = null;
	String hourFilter = null;



	MeetingListAdapter adapter = new MeetingListAdapter(); // On crée une instance de MeetingListAdapter

	@Override
	protected  void onCreate(Bundle savedInstanceState) {


		getSupportActionBar().setTitle("Ma réu");

		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meeting_recycler_list);

		list = findViewById(R.id.recycler_meeting_list);
		buttonAddMeeting = findViewById(R.id.buttonAddMeeting);



		list.setLayoutManager(new LinearLayoutManager(this));




		list.setAdapter(adapter); // On appelle l'adapter

		adapter.setAdapterItemClickListener(new MeetingListAdapter.OnAdapterItemClickListener() {

			@Override
			public void onAdapterItemClickListener(Meeting meeting , int position) {
				MeetingApiService mApiService = DI.getMeetingApiService();
				mApiService.deleteMeeting(meeting);
				adapter.SetItems(mApiService.getMeetings());
			}
		});

		// On écoute le clic sur bouton d'ajout d'une réunion pour pouvoir ensuite changer d'écran lors du clic

		buttonAddMeeting.setOnClickListener(new View.OnClickListener() {



			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MeetingListActivity.this, AddMeetingActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.place_filter) {
			String[] placeChoice = {"Mario", "Luigi", "Warrio"};
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Pick a place");
			builder.setItems(placeChoice, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					namePlaceFilter = placeChoice[which];
					updatePlaceList();
				}
			});
			builder.show();
			return true;
		}

		if (id == R.id.hour_filter) {
			String[] hourChoice = {"9", "10", "11", "14", "15", "16", "17", "18", "19"};
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Pick an hour");
			builder.setItems(hourChoice, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					hourFilter = hourChoice[which];
					updateHourList();
				}
			});
			builder.show();
			return true;
		}

		if (id == R.id.clear_filter) {
			namePlaceFilter = null;
			updatePlaceList();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() { // On récupère les informations des champs de l'écran de création d'une réunion
		super.onResume();
		MeetingApiService mApiService = DI.getMeetingApiService();
		adapter.SetItems(mApiService.getMeetings());
	}

	private void updatePlaceList() {
		MeetingApiService meetingApiService = DI.getMeetingApiService();
		List<Meeting> allMeetings = meetingApiService.getMeetings();
		List<Meeting> meetingsFilteredByRoom = filterByRoom(allMeetings, namePlaceFilter);
		adapter.SetItems(meetingsFilteredByRoom);
	}

	private void updateHourList() {
		MeetingApiService meetingApiService = DI.getMeetingApiService();
		List<Meeting> allMeetings = meetingApiService.getMeetings();
		List<Meeting> meetingsFilteredByRoom = filterByRoom(allMeetings, hourFilter);
		adapter.SetItems(meetingsFilteredByRoom);
	}

	private List<Meeting> filterByRoom(List<Meeting> allMeetings, String namePlaceFilter) {
		List<Meeting> filteredMeetings = new ArrayList<>();
		for (Meeting meeting : allMeetings) {
			if (namePlaceFilter == null || meeting.place.equals(namePlaceFilter)) {
				filteredMeetings.add(meeting);
			}else if (hourFilter == null || meeting.hour.equals(hourFilter)) {
				filteredMeetings.add(meeting);
			} else {

			}
		}
		return filteredMeetings;
	}







}

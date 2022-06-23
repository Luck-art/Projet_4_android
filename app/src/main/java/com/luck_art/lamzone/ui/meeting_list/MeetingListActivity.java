package com.luck_art.lamzone.ui.meeting_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

	View filterMario;
	View filterLuigi;
	View filterWarrio;
	View filterClear;

	String namePlaceFilter = "";



	MeetingListAdapter adapter = new MeetingListAdapter(); // On crée une instance de MeetingListAdapter

	@Override
	protected  void onCreate(Bundle savedInstanceState) {


		getSupportActionBar().setTitle("Ma réu");

		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meeting_recycler_list);

		list = findViewById(R.id.recycler_meeting_list);
		buttonAddMeeting = findViewById(R.id.buttonAddMeeting);
		filterMario = findViewById(R.id.place);
		filterLuigi = findViewById(R.id.place);
		filterWarrio = findViewById(R.id.place);
		filterClear = findViewById(R.id.place);


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

		filterMario.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				namePlaceFilter = "Mario";
				updatePlaceList();
			}
		});

		filterLuigi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				namePlaceFilter = "Luigi";
				updatePlaceList();
			}
		});

		filterWarrio.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				namePlaceFilter = "Warrio";
				updatePlaceList();
			}
		});

		filterClear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				namePlaceFilter = "Clear";
				updatePlaceList();
			}
		});

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

	private List<Meeting> filterByRoom(List<Meeting> allMeetings, String namePlaceFilter) {
		List<Meeting> filteredMeetings = new ArrayList<>();
		for (Meeting meeting : allMeetings) {
			if (namePlaceFilter == null || meeting.place.equals(namePlaceFilter)) {
				filteredMeetings.add(meeting);
			} else {

			}
		}
		return filteredMeetings;
	}







}

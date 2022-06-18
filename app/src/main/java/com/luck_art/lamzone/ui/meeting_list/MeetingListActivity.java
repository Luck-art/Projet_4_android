package com.luck_art.lamzone.ui.meeting_list;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
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
	protected void onResume() { // On récupère les informations des champs de l'écran de création d'une réunion
		super.onResume();
		MeetingApiService mApiService = DI.getMeetingApiService();
		adapter.SetItems(mApiService.getMeetings());
	}





}

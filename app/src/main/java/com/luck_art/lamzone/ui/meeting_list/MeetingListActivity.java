package com.luck_art.lamzone.ui.meeting_list;

import android.app.Activity;
import android.content.Intent;
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

	ArrayList<Meeting> listMeetings = new ArrayList<>();


	@Override
	protected  void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meeting_recycler_list);

		list = findViewById(R.id.recycler_meeting_list);
		buttonAddMeeting = findViewById(R.id.buttonAddMeeting);

		list.setLayoutManager(new LinearLayoutManager(this));

		recyclerMeetings(); // on appelle la méthode recyclerMeetings

		MeetingListAdapter adapter = new MeetingListAdapter(); // On crée une instance de MeetingListAdapter

		adapter.SetItems(listMeetings);


		list.setAdapter(adapter); // On appelle l'adapter

		adapter.setAdapterItemClickListener(new MeetingListAdapter.OnAdapterItemClickListener() {

			@Override
			public void onAdapterItemClickListener(Meeting meeting , int position) {
				listMeetings.remove(meeting);
				adapter.SetItems(listMeetings);
			}
		});

		buttonAddMeeting.setOnClickListener(new View.OnClickListener() {

			MeetingApiService mApiService;

			@Override
			public void onClick(View v) {
				//TODO appeller le deuxième écran (fragment)

				Intent intent = new Intent(MeetingListActivity.this, AddMeetingActivity.class);
				startActivity(intent);
			}
		});

	}



	private void recyclerMeetings() {
		listMeetings.add(new Meeting(0,"15h30","Mario","ABC","blabla@gmail.com"));
		listMeetings.add(new Meeting(1,"17h30","Luigi","asd","luigi@gmail.com"));
	}


}

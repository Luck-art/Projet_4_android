package com.luck_art.lamzone.ui.meeting_list;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luck_art.lamzone.R;
import com.luck_art.lamzone.model.Meeting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MeetingListAdapter extends RecyclerView.Adapter<MeetingListAdapter.ListHolder> {



	ArrayList<Meeting> dataSet = new ArrayList<>(); // sert pour faire une liste des réunions


	public MeetingListAdapter() {

	}

	public void setAdapterItemClickListener(OnAdapterItemClickListener adapterItemClickListener) {
		this.adapterItemClickListener = adapterItemClickListener;
	}

	interface OnAdapterItemClickListener {
		void onAdapterItemClickListener(Meeting meeting, int position);
	}

	private OnAdapterItemClickListener adapterItemClickListener = null;

	public void SetItems(List<Meeting> newList) { // Donne la liste des models à afficher
		this.dataSet.clear();
		this.dataSet.addAll(newList);
		notifyDataSetChanged();
	}



	@NonNull
	@NotNull
	@Override
	public ListHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

		View viewMeetingList = LayoutInflater.from(parent.getContext()).inflate(R.layout.meeting_list, parent, false); // on invoque le fichier xml meeting_list


		return new ListHolder(viewMeetingList);
	}

	@Override
	public void onBindViewHolder(@NonNull ListHolder holder, int position) {

		Meeting m = dataSet.get(position);

		holder.setDetailsMeeting(m, position);

	}

	@Override
	public int getItemCount() {
		return dataSet.size();
	}

	class ListHolder extends RecyclerView.ViewHolder {

		ImageView imageName;
		View imageTrash;
		TextView meetingName;
		TextView mailName;
		TextView topicName;
		TextView hourName;

		public ListHolder(@NonNull View itemView) {
			super(itemView);

			imageName = itemView.findViewById(R.id.iconeMeeting);
			imageTrash = itemView.findViewById(R.id.buttonTrash);
			meetingName = itemView.findViewById(R.id.textPLace);
			topicName = itemView.findViewById(R.id.textTopic);
			mailName = itemView.findViewById(R.id.textMail);
			hourName = itemView.findViewById(R.id.textHour);
		}

		void setDetailsMeeting(Meeting meeting, int position) {

			int color  ;

			if (meeting.getPlace().equals("Mario")) {
				color = Color.parseColor("#AA7845");
			} else if (meeting.getPlace().equals(("Luigi"))) {
				color = Color.parseColor("#BC1511");
			} else if(meeting.getPlace().equals(("Warrio"))) {
				color = Color.parseColor("#FF4523");
			} else {
				color = Color.parseColor("#DDD879");
			}

			imageName.setColorFilter(color);
			meetingName.setText(meeting.getPlace() + " -");


			String emailsString = "";
			for (int i = 0; i < meeting.getMail().size() ; i++) {
				emailsString += meeting.getMail().get(i);
				if (i != meeting.getMail().size() -1) {
					emailsString += ", " ;
				}
			}

			mailName.setText(emailsString);


			topicName.setText(meeting.getTopic());
			hourName.setText(meeting.getHour() + " -");
			imageTrash.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					adapterItemClickListener.onAdapterItemClickListener(meeting, position);
				}
			});
		}

	}

}

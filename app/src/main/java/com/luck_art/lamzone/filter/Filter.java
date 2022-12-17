package com.luck_art.lamzone.filter;

import com.luck_art.lamzone.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class Filter {


	public static List<Meeting> filterByRoom(List<Meeting> allMeetings, String namePlaceFilter) {
		List<Meeting> filteredMeetings = new ArrayList<>();
		for (Meeting meeting : allMeetings) {
			if (namePlaceFilter == null || meeting.place.equals(namePlaceFilter)) {
				filteredMeetings.add(meeting);
			}
		}
		return filteredMeetings;
	}

	public static List<Meeting> filterByTime(List<Meeting> allMeetings, String hourFilter) {
		int convertHour = 0;
		if( hourFilter != null) {
			convertHour = Integer.parseInt(hourFilter);
		}
		List<Meeting> filteredMeetings = new ArrayList<>();
		for (Meeting meeting : allMeetings) {
			if (hourFilter == null || meeting.date.getHours() >= convertHour) {
				filteredMeetings.add(meeting);
			}
		}
		return filteredMeetings;
	}

}

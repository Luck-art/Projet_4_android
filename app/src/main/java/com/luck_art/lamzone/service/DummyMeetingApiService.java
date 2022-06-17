package com.luck_art.lamzone.service;


import com.luck_art.lamzone.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

	private List<Meeting> meetings = new ArrayList<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Meeting> getMeetings() {
		return meetings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteMeeting(Meeting meeting) {
		meetings.remove(meeting);
	}

	/**
	 * {@inheritDoc}
	 * @param meeting
	 */
	@Override
	public boolean createMeeting(Meeting meeting) {



		for (Meeting m : meetings) {
			if (m.place.equals(meeting.place) && m.hour.equals(meeting.hour)) {
				return false;
			} else {
				meetings.add(meeting);
				return true;
			}

		}

		return true;
	}

}

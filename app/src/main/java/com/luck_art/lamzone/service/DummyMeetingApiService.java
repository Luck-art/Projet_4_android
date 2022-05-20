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
	public void createMeeting(Meeting meeting) {
		meetings.add(meeting);
	}

}

package com.luck_art.lamzone.service;

import com.luck_art.lamzone.model.Meeting;

import java.util.List;

public interface MeetingApiService {

	/**
	 * Get all my Meetings
	 * @return {@link List}
	 */
	List<Meeting> getMeetings();

	/**
	 * Deletes a meetings
	 * @param meeting
	 */
	void deleteMeeting(Meeting meeting);

	/**
	 * Create a meeting
	 * @param meeting
	 */
	boolean createMeeting(Meeting meeting);

}

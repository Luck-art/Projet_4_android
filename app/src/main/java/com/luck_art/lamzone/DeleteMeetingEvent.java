package com.luck_art.lamzone;

import com.luck_art.lamzone.model.Meeting;

public class DeleteMeetingEvent {

	/**
	 * Meeting to delete
	 */
	public Meeting meeting;

	/**
	 * Constructor.
	 * @param meeting
	 */
	public DeleteMeetingEvent(Meeting meeting) {
		this.meeting = meeting;
	}

}

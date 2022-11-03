package com.luck_art.lamzone.service;


import com.luck_art.lamzone.model.Meeting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	private Date getEndDate(Date start, int durationMinutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		calendar.add(Calendar.MINUTE, durationMinutes);
		return calendar.getTime();
	}

	private boolean inSameTime(Meeting meeting, Meeting other) {
		Date otherStart = other.date;
		Date otherEnd = getEndDate(otherStart, other.duringMinutes);

		Date meetingStart = meeting.date;
		Date meetingEnd = getEndDate(meetingStart, other.duringMinutes);

		//other.startDate < `meeting.startDate` < other.date + duree
		if(otherStart.before(meetingStart) && meetingStart.before(otherEnd)) {
			return true;
		}
		//other.startDate < `meeting.endDate` < other.date + duree
		if(otherStart.before(meetingEnd) && meetingEnd.before(otherEnd)) {
			return true;
		}
		//meeting.startDate < `other.startDate` < meeting.date + duree
		if(meetingStart.before(otherStart) && otherStart.before(meetingEnd)) {
			return true;
		}
		//meeting.startDate < `other.endDate` < meeting.date + duree
		if(meetingStart.before(otherEnd) && otherEnd.before(meetingEnd)) {
			return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * @param meeting
	 */
	@Override
	public boolean createMeeting(Meeting meeting) {
		for (Meeting m : meetings) {
			if (m.place.equals(meeting.place) && inSameTime(m, meeting)) {
				return false;
			}
		}
		meetings.add(meeting);
		return true;
	}


	@Override
	public void clear(){
		meetings.clear();
	}

}

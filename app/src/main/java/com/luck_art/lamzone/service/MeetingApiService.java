package com.luck_art.lamzone.service;

import com.luck_art.lamzone.model.Meeting;

import java.util.List;

public interface MeetingApiService {


	List<Meeting> getMeetings();


	void deleteMeeting(Meeting meeting);


	boolean createMeeting(Meeting meeting);



	void clear();
}

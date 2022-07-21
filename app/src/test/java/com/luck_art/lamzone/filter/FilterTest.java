package com.luck_art.lamzone.filter;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.luck_art.lamzone.model.Meeting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterTest {



	@Test
	public void testFilterByRoom() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","11","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"));; // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","14","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"));; // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","15","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"));; // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResultMario = Filter.filterByRoom(meetingsTestList, "Mario");
		assertFalse(ResultMario.contains(meetingToCreateTwo));
		assertTrue(ResultMario.contains(meetingToCreateOne));
		assertTrue(ResultMario.contains(meetingToCreateThree));
	}

	@Test
	public void testFilterByRoom_null() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","11","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com")); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","14","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com")); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","15","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com")); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResumeMario = Filter.filterByRoom(meetingsTestList, null);
		assertTrue(ResumeMario.contains(meetingToCreateTwo));
		assertTrue(ResumeMario.contains(meetingToCreateOne));
		assertTrue(ResumeMario.contains(meetingToCreateThree));
	}


	@Test
	public void testFilterByTime() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","11","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com")); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","14","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com")); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","14","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com")); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResumeMario = Filter.filterByTime(meetingsTestList, null);
		assertTrue(ResumeMario.contains(meetingToCreateTwo));
		assertTrue(ResumeMario.contains(meetingToCreateOne));
		assertTrue(ResumeMario.contains(meetingToCreateThree));

	}
}
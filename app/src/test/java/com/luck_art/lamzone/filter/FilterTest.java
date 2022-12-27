package com.luck_art.lamzone.filter;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.luck_art.lamzone.model.Meeting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FilterTest {

	Date date(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}


	@Test
	public void testFilterByRoom() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(11), 30);; // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(14), 30);; // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(15), 30);; // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResultMario = Filter.filterByRoom(meetingsTestList, "Mario");
		assertFalse(ResultMario.contains(meetingToCreateTwo));
		assertTrue(ResultMario.contains(meetingToCreateOne));
		assertTrue(ResultMario.contains(meetingToCreateThree));
	}

	@Test
	public void testFilterByRoom_null() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(11), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(14), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"), date(15),30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResumeMario = Filter.filterByRoom(meetingsTestList, null);
		assertTrue(ResumeMario.contains(meetingToCreateTwo));
		assertTrue(ResumeMario.contains(meetingToCreateOne));
		assertTrue(ResumeMario.contains(meetingToCreateThree));
	}


	@Test
	public void testFilterByTime() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(11), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(14), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(9), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResumeMario = Filter.filterByTime(meetingsTestList, "11");
		assertTrue(ResumeMario.contains(meetingToCreateTwo));
		assertTrue(ResumeMario.contains(meetingToCreateOne));
		assertFalse(ResumeMario.contains(meetingToCreateThree));

	}


	@Test
	public void testFilterByTime_null() {

		List<Meeting> meetingsTestList = new ArrayList<>();

		Meeting meetingToCreateOne = new Meeting(1,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(11), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateOne);
		Meeting meetingToCreateTwo = new Meeting(2,"Luigi","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(14), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateTwo);
		Meeting meetingToCreateThree = new Meeting(3,"Mario","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(14), 30); // Index 0 out of bounds for length 0
		meetingsTestList.add(meetingToCreateThree);

		List<Meeting> ResumeMario = Filter.filterByTime(meetingsTestList, null);
		assertTrue(ResumeMario.contains(meetingToCreateTwo));
		assertTrue(ResumeMario.contains(meetingToCreateOne));
		assertTrue(ResumeMario.contains(meetingToCreateThree));

	}
}
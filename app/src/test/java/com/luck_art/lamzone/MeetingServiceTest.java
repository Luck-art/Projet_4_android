package com.luck_art.lamzone;

import com.luck_art.lamzone.di.DI;
import com.luck_art.lamzone.model.Meeting;
import com.luck_art.lamzone.service.MeetingApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Meeting service
 */
@RunWith(JUnit4.class)
public class MeetingServiceTest {


    Date date(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    private MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetingsWithSuccess() {
        List<Meeting> meetings = service.getMeetings();
        assertTrue(meetings.size() == 0);
    }


    @Test
    public void createMeetingWithSuccess() {
        Meeting meetingToCreate = new Meeting(1,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"),date(11), 30);; // Index 0 out of bounds for length 0
        service.createMeeting(meetingToCreate);
        assertTrue(service.getMeetings().contains(meetingToCreate));
    }

    @Test
    public void createMeetingWithSuccess_double() {
        Meeting meetingToCreate = new Meeting(3,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"), date(11), 30);; // Index 0 out of bounds for length 0
        service.createMeeting(meetingToCreate);
        Meeting meetingToCreateError = new Meeting(4,"Mario","blabla", Collections.singletonList("mario@gmail.com, warrio@gmail.com"), date(11), 30);; // Index 0 out of bounds for length 0
        boolean added = service.createMeeting(meetingToCreateError); // Create second meeting in same place in same hour for test error
        assertFalse(added); // Insert this second meeting for test error
        assertTrue(service.getMeetings().size() == 1); //  Verify only a true meeting is here
    }

    @Test
    public void deleteMeetingWithSuccess() {
        Meeting meetingToCreateOne = new Meeting(1,"Mario","New project", Collections.singletonList("mario@gmail.com, luigi@gmail.com"), date(11), 30);; // Index 0 out of bounds for length 0
        service.createMeeting(meetingToCreateOne);
        Meeting meetingToCreateTwo = new Meeting(2,"Luigi","New...", Collections.singletonList("mario@gmail.com, luigi@gmail.com"), date(14), 30);; // Index 0 out of bounds for length 0
        service.createMeeting(meetingToCreateTwo);

        service.deleteMeeting(meetingToCreateOne);
        assertFalse(service.getMeetings().contains(meetingToCreateOne));
        assertTrue(service.getMeetings().contains(meetingToCreateTwo));
    }
}

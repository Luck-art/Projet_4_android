package com.luck_art.lamzone.di;

import com.luck_art.lamzone.service.DummyMeetingApiService;
import com.luck_art.lamzone.service.MeetingApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    private static MeetingApiService service = new DummyMeetingApiService();


    public static MeetingApiService getMeetingApiService() {
        return service;
    }


    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }

}

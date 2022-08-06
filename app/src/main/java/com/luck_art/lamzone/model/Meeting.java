package com.luck_art.lamzone.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Meeting implements Serializable {


	private long id;

	public String hour;

	public String place;

	private String topic;

	private List<String> mails;


	/** Constructor
     * @param id
     * @param hour
	 * @param place
	 * @param topic
	 * @param mails
     */

	public Meeting(long id, String place, String hour,
	               String topic, List<String> mails) {
		this.id = id;
		this.hour = hour;
		this.place = place;
		this.topic = topic;
		this.mails = mails;
	}


	public long getId() {
		return id;
	}

	public String getHour() {
		return hour;
	}

	public String getPlace() {
		return place;
	}

	public String getTopic() {
		return topic;
	}

	public List<String> getMail() {
		return mails;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Meeting meeting = (Meeting) o;
		return id == meeting.id && Objects.equals(hour, meeting.hour) && Objects.equals(place, meeting.place) && Objects.equals(topic, meeting.topic) && Objects.equals(mails, meeting.mails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, hour, place, topic, mails);
	}
}

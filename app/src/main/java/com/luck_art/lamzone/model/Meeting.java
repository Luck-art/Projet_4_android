package com.luck_art.lamzone.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Meeting implements Serializable {


	public Date date;

	public int duringMinutes;

	private long id;

	public String place;

	private String topic;

	private List<String> mails;


	/** Constructor
	 * @param id
		* @param place
	 * @param topic
	 * @param mails
	 * @param meetingDuration
	 */

	public Meeting(long id, String place,
	               String topic, List<String> mails, Date date, int duringMinutes) {
		this.id = id;
		this.place = place;
		this.topic = topic;
		this.mails = mails;
		this.date = date;
		this.duringMinutes = duringMinutes;
	}


	public long getId() {
		return id;
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
		return id == meeting.id && Objects.equals(date, meeting.date) && Objects.equals(place, meeting.place) && Objects.equals(topic, meeting.topic) && Objects.equals(mails, meeting.mails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, place, topic, mails);
	}
}

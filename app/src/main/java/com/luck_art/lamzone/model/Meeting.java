package com.luck_art.lamzone.model;

import java.io.Serializable;
import java.util.Objects;

public class Meeting implements Serializable {


	private long id;

	public String hour;

	public String place;

	private String topic;

	private String mail;


	/** Constructor
     * @param id
     * @param hour
	 * @param place
	 * @param topic
	 * @param mail
     */

	public Meeting(long id,String place, String hour,
	                 String topic, String mail) {
		this.id = id;
		this.hour = hour;
		this.place = place;
		this.topic = topic;
		this.mail = mail;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) { this.hour = hour; }

	public String getPlace() {
		return place;
	}

	public void setPLace() {
		this.place = place;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Meeting meeting = (Meeting) o;
		return Objects.equals(id, meeting.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}

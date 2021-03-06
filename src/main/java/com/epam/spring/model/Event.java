package com.epam.spring.model;

import java.text.DateFormat;
import java.util.Date;

public class Event {
	
	private int id;
	private String msg;
	private Date date;
	private DateFormat df;
	private EventType eventType;

	public Event(Date date, DateFormat df) {
		this.date = date;
		this.df = df;
		this.id = (int) Math.random();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + df.format(date) + "]";
	}

}

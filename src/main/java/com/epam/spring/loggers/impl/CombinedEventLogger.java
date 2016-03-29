package com.epam.spring.loggers.impl;

import java.util.List;

import com.epam.spring.loggers.EventLogger;
import com.epam.spring.model.Event;

public class CombinedEventLogger implements EventLogger {

	private List<EventLogger> eventLoggers;
	
	public CombinedEventLogger(List<EventLogger> eventLoggers) {
		this.eventLoggers = eventLoggers;
	}

	public void logEvent(Event event) {
		for (EventLogger eventLogger : eventLoggers) {
			eventLogger.logEvent(event);
		}
	}

}

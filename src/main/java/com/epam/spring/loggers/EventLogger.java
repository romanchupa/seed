package com.epam.spring.loggers;

import com.epam.spring.model.Event;

public interface EventLogger {
	
	public void logEvent(Event event);

}

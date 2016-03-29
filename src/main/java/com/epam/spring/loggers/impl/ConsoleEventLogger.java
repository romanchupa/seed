package com.epam.spring.loggers.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.epam.spring.loggers.EventLogger;
import com.epam.spring.model.Event;

public class ConsoleEventLogger implements EventLogger{

	private static Log LOG = LogFactory.getLog(ConsoleEventLogger.class);

	public void logEvent(Event event) {
		LOG.info(event.getMsg());
	}

}

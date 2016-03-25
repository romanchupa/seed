package com.epam.spring.loggers.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.epam.spring.loggers.EventLogger;

public class ConsoleEventLogger implements EventLogger{

	private static Log LOG = LogFactory.getLog(ConsoleEventLogger.class);

	public void logEvent(String msg) {
		LOG.info(msg);

	}

}

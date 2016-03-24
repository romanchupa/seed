package com.epam.spring.loggers;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConsoleEventLogger {

	private static Log LOG = LogFactory.getLog(ConsoleEventLogger.class);

	public void logEvent(String msg) {
		LOG.info(msg);

	}

}

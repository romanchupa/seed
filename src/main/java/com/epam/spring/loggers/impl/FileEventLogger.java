package com.epam.spring.loggers.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.epam.spring.loggers.EventLogger;
import com.epam.spring.model.Event;

public class FileEventLogger implements EventLogger {

	private String fileName;
	private File file;
	
	public void init() throws IOException{
		this.file = new File(fileName);
	}
	
	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file,event.getMsg(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

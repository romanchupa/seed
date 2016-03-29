package com.epam.spring.loggers.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.spring.model.Event;

public class CacheFileEventLogger extends FileEventLogger {

	public CacheFileEventLogger(String fileName) {
		super(fileName);
	}

	private int casheSize;
	private List<Event> cashe;

	@Override
	public void logEvent(Event event) {
		cashe.add(event);
		
		if(cashe.size() == casheSize){
			writeEventsFromCashe();
		}
	}
	
	private void writeEventsFromCashe() {
		for (Event event : cashe) {
			super.logEvent(event);
		}
	}
	
	public void init() throws IOException{
		this.cashe = new ArrayList<Event>();
		super.init();
	} 

	public void destroy(){
		if(!cashe.isEmpty()){
			writeEventsFromCashe();
		}
	}

	public int getCasheSize() {
		return casheSize;
	}

	public void setCasheSize(int casheSize) {
		this.casheSize = casheSize;
	}
	

}

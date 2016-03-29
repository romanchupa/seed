package com.epam.spring.core;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.loggers.EventLogger;
import com.epam.spring.model.Client;
import com.epam.spring.model.Event;
import com.epam.spring.model.EventType;

/**
 * Spring
 *
 */
public class App 
{
	private EventLogger defaultLogger;
	private Map<EventType,EventLogger> loggers;
	private Client client;
	
    public App(EventLogger consoleLogger, Client client,Map<EventType,EventLogger> loggers) {
		this.defaultLogger = consoleLogger;
		this.client = client;
		this.loggers = loggers;
	}

	public static void main( String[] args )
    {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        event.setMsg(" message 1");
        
        app.logEvent(event,null);
        app.logEvent(event,EventType.INFO);
        app.logEvent(event,EventType.ERROR);
        
        ctx.close();
    }
    
    private void logEvent(Event event,EventType type){

    	EventLogger logger = loggers.get(type);
    	if(type == null){
    		logger = defaultLogger;
    	}
    	
    	logger.logEvent(event);
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
	
    
    
}

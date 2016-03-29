package com.epam.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.loggers.EventLogger;
import com.epam.spring.model.Client;
import com.epam.spring.model.Event;

/**
 * Spring
 *
 */
public class App 
{
	private EventLogger consoleLogger;
	private Client client;
	
    public App(EventLogger consoleLogger, Client client) {
		super();
		this.consoleLogger = consoleLogger;
		this.client = client;
	}

	public static void main( String[] args )
    {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        event.setMsg(" test 1");
        
        app.logEvent(event);
        app.logEvent(event);
        app.logEvent(event);
        
        ctx.close();
    }
    
    private void logEvent(Event event){
    	String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
    	event.setMsg(message);
    	consoleLogger.logEvent(event);
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
	
    
    
}

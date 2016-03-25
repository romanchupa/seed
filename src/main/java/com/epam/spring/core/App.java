package com.epam.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.loggers.impl.ConsoleEventLogger;
import com.epam.spring.model.Client;
import com.epam.spring.model.Event;

/**
 * Spring
 *
 */
public class App 
{
	private ConsoleEventLogger consoleLogger;
	private Client client;
	
    public App(ConsoleEventLogger consoleLogger, Client client) {
		super();
		this.consoleLogger = consoleLogger;
		this.client = client;
	}

	public static void main( String[] args )
    {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        event.setMsg("hello 1");
        
        app.logEvent(event);
    }
    
    private void logEvent(Event event){
    	String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
    	consoleLogger.logEvent(message);
    }

	public ConsoleEventLogger getConsoleLogger() {
		return consoleLogger;
	}

	public void setConsoleLogger(ConsoleEventLogger consoleLogger) {
		this.consoleLogger = consoleLogger;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
	
    
    
}

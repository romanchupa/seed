package com.epam.spring.core;

import com.epam.spring.loggers.ConsoleEventLogger;
import com.epam.spring.model.Client;

/**
 * Spring
 *
 */
public class App 
{
	private ConsoleEventLogger consoleLogger;
	private Client client;
	
    public static void main( String[] args )
    {
        App app = new App();
        
        app.setClient(new Client("1","Roman Chupa"));
        app.setConsoleLogger(new ConsoleEventLogger());
        
        app.logEvent("event 1");
    }
    
    private void logEvent(String msg){
    	String message = msg.replaceAll(client.getId(), client.getFullName());
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

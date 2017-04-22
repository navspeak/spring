package com.nav.spring;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FileWriter implements ILogWriter {

	public void write(String text) {
		// Write to a file here.
		// Dummy implementation
		System.out.println("Write to file: " + text);
		
	}
	
	public void defaultInit(){
		System.out.println("Def Init of FileWriter Bean");
	}

}

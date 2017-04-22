package com.nav.spring;
import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements ILogWriter {

	public void write(String text) {
		System.out.println(text);
	}

	public void defaultInit(){
		System.out.println("Def Init of ConsoleWriter Bean");
	}
	
	public static void anotherInit(){
		System.out.println("Another Init of ConsoleWriter Bean");
	}
}

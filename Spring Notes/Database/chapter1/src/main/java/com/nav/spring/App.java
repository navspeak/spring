package com.nav.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/nav/spring/beans.xml");
		
		Logger logger = (Logger)context.getBean("logger");
		
		logger.writeConsole("Hello there");
		logger.writeFile("Hi again");
		
		((ClassPathXmlApplicationContext)context).close();
	}

}

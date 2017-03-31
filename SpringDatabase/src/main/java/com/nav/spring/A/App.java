package com.nav.spring.A;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/nav/spring/beans/beans1.xml");

		Robot robot = (Robot)context.getBean("robot");

		//robot.speak();


		((ClassPathXmlApplicationContext)context).close();
	}

}

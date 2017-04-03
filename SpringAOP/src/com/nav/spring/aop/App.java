package com.nav.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// spring supports AspectJ syntax
	// Aspect - advice
	// This method advises this method
	// Spring AOP supports only Execution Joinpoint
	// pointcut defines a jointpoint
	
	

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/nav/spring/aop/beans.xml");
	
		Object obj = context.getBean("camera");
		System.out.println("Class of camera bean " + obj.getClass());
		// if doesnt implement an interface: com.nav.spring.aop.Camera$$EnhancerBySpringCGLIB$$477a9059
		// if implements an interface: 
		System.out.println(obj instanceof Machine); //true
		Camera camera = (Camera) obj;
		Lens lens = (Lens)context.getBean("lens");
		
		// Here when you do a get, spring actually gives you not the actual camera bean
		// but a proxy class which combines the aspect class (i.e. Logger here)
		
		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println("Exception in snap : "+ e.getMessage());
		}
//		camera.snap(1000);
//		camera.snap("Charminar");
//		
//		lens.zoom(5);
		
		context.close();
	}

}

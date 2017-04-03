package com.nav.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Camera implements PhotoSnapper, Machine {
	
	public Camera() {
		System.out.println("Constructor...");
	}
	public void snap() throws Exception{
		System.out.println("SNAP!");
		//throw new Exception("Exception occurred! Bye");
	}
	
	public void snap(int exposure) {
		System.out.println("SNAP! "+ exposure );
	}
	
	public String snap(String name) {
		System.out.println("SNAP! "+ name );
		return name;
	}
	
	public String snapNightTime(String name) {
		System.out.println("SNAP! "+ name );
		return name;
	}
}

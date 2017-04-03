package com.nav.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.nav.spring.web.validation.ValidEmail;

@Component
public class Offer {
	
		
	private int id = 0;

	@Size(min=5, max=10, message="Name must be between 5 and 10 characters")
	private String name;
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="This doesn't appear to be a valid email")
	@ValidEmail(min=6, message="Invalid Email") //our custom validator
	private String email;
	@Size(min=10, max=200, message="Name must be between 5 and 100 characters")
	private String text;
	
	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public Offer(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public Offer() {};

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}

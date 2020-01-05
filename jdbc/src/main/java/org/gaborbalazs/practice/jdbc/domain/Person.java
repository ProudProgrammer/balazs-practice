package org.gaborbalazs.practice.jdbc.domain;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
	
	private int id;
	private String name;
	private LocalDateTime registration;
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
	
	public Person() {}
	
	public Person(int id, String name, LocalDateTime registration) {
		this.id = id;
		this.name = name;
		this.registration = registration;
	}
	
	public Person(String name, LocalDateTime registration) {
		this(0, name, registration);
	}
	
	public int getId() {
		return id;
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

	public LocalDateTime getRegistration() {
		return registration;
	}

	public void setRegistrationTime(LocalDateTime registration) {
		this.registration = registration;
	}

	public String toString() {
		return MessageFormat.format("[Person [id={0}, name={1}, registration={2}]]", id, name, registration);
	}
}
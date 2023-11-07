package com.my.customer.dto;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected String address;
	
	public Person() {}
	public Person(String name, String address) {
		this.name=name;
		this.address=address;
	}

	public String toString() {
		return "name은 "+name+", address는 "+address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
}

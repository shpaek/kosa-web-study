package com.my.customer.dto;

public class Customer extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	transient private String pwd; //직렬화 제외
	
	
	public Customer() {}
	public Customer(String id, String pwd) {
		this.id=id;
		this.pwd=pwd;
	} 
	public Customer(String id, String pwd, String name, String address) {
		this(id, pwd);
		super.name=name;
		super.address=address;
	}

	public String toString() {
		return "id는 "+id+", pwd는 "+pwd+", name은 "+name+", address는 "+address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
}

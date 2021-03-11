package com.hefshine.bean;

public class RegisterBean {

	String name;
	String number;
	String username;
	String password;
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegisterBean(String name, String number, String username, String password) {
		super();
		this.name = name;
		this.number = number;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegisterBean [name=" + name + ", number=" + number + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
	
	
}

package com.hefshine.bean;

public class NewContactBean {
	
	String fname;
	String lname;
	String number;
	String sim;
	public NewContactBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewContactBean(String fname, String lname, String number, String sim) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.number = number;
		this.sim = sim;
		// abdul
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	@Override
	public String toString() {
		return "NewContactBean [fname=" + fname + ", lname=" + lname + ", number=" + number + ", sim=" + sim + "]";
	}
	
	

}

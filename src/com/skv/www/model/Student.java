package com.skv.www.model;

public class Student {

	private Integer rollNum;
	private String name;
	private String clgname;
	private String city;
	private double percentage;
	
	public Student() {
		
	}

	public Student(String name, String clgname, String city, double percentage) {
		super();
		this.name = name;
		this.clgname = clgname;
		this.city = city;
		this.percentage = percentage;
	}

	public Student(Integer rollNum, String name, String clgname, String city, double percentage) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.clgname = clgname;
		this.city = city;
		this.percentage = percentage;
	}

	public Integer getRollNum() {
		return rollNum;
	}

	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClgname() {
		return clgname;
	}

	public void setClgname(String clgname) {
		this.clgname = clgname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + ", clgname=" + clgname + ", city=" + city
				+ ", percentage=" + percentage + "]";
	}
	
	
	
	
}

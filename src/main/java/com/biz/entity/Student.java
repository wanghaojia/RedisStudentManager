package com.biz.entity;

public class Student {
	
	private String id;
	private String name;
	private String birthday;
	private String description;
	private String avgscore;
	
	public Student() {
	}
	public Student(String id, String name, String birthday, String description, String avgscore) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.description = description;
		this.avgscore = avgscore;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(String avgscore) {
		this.avgscore = avgscore;
	}
	
}

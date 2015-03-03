package model;

import java.util.ArrayList;

public class Group {
	private String name;
	private String service;
	private ArrayList<User> members;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	
}

package model;

import java.util.ArrayList;

public class Group {
	private int idGroup;
	private String name;
	private String service;
	private ArrayList<User> members;
	
	
	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public static void createGroup() { // this function must not be called out of the servlet SuggboxDB
//		StackTraceElement[] e = Thread.currentThread().getStackTrace();
//
//		if(!e[2].getClassName().equals("servlets.SuggboxDB"))
//			System.out.println("Warning: the caller is not SuggboxDB");
//		idGroup++;
	}
	
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

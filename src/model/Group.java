package model;

import java.util.ArrayList;

import database.SuggboxDB;

public class Group {
	private int idGroup;
	private String name;
	private String service;
	
	
	
	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public  void createGroup() { // this function must not be called out of the servlet SuggboxDB
		idGroup=SuggboxDB.getInstance().getLastRow("group")+1;
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

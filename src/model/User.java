package model;

import database.SuggboxDB;

public class User {

private int idUser; 	
private String firstName;
private String lastName;
private String login;
private boolean isAdmin=false;

public int getIdUser() {
	return idUser;
}

public void setIdUser(int idUser) {
	this.idUser = idUser;
}

public void createUser() {  // this function must not be called out of the servlet SuggboxDB
//	StackTraceElement[] e = Thread.currentThread().getStackTrace();
//
//	if(!e[2].getClassName().equals("servlets.SuggboxDB"))
//		System.out.println("Warning: the caller is not SuggboxDB");
//	idUser++;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}

}

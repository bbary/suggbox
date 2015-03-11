package model;

import servlets.Example;
import database.SuggboxDB;

public class User {

private static int idUser=0; 	
private String firstName;
private String lastName;
private String login;
private boolean isAdmin=false;

public static int getIdUser() {
	return idUser;
}
public static void createUser() {  // this function must not be called out of the servlet SuggboxDB
	StackTraceElement[] e = Thread.currentThread().getStackTrace();

	if(!e[2].getClassName().equals("servlets.SuggboxDB"))
		System.out.println("Warning: the caller is not SuggboxDB");
	idUser++;
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

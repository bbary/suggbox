package model;

import database.SuggboxDB;

public class Note {
	private int idNote;
	private int stars;

	public int getIdNote() {
		return idNote;
	}

	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	public  void createNote() { // this function must not be called out of the servlet SuggboxDB
		idNote=SuggboxDB.getInstance().getLastRow("note")+1;
	}
	
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}

	
	
}

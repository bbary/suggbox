package model;

import java.util.ArrayList;

public class Idea {

	private static int idIdea=0; 
	private String ideaText;
	private String ideaTitle;
	private User ideaOwner;
	private ArrayList<Comment> comments;
	private ArrayList<Note> notes;
	
	public ArrayList<Note> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
	public static int getIdIdea() {
		return idIdea;
	}
	public static void createIdea() { // this function must not be called out of the servlet SuggboxDB
		StackTraceElement[] e = Thread.currentThread().getStackTrace();

		if(!e[2].getClassName().equals("servlets.SuggboxDB"))
			System.out.println("Warning: the caller is not SuggboxDB");
		idIdea++;
	}
	
//	public Note getNote() {
//		return note;
//	}
//	public void setNote(Note note) {
//		this.note = note;
//	}
	public String getIdeaText() {
		return ideaText;
	}
	public void setIdeaText(String ideaText) {
		this.ideaText = ideaText;
	}
	public String getIdeaTitle() {
		return ideaTitle;
	}
	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}
	public User getIdeaOwner() {
		return ideaOwner;
	}
	public void setIdeaOwner(User ideaOwner) {
		this.ideaOwner = ideaOwner;
	}
	
	
}

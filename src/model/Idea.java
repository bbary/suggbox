package model;

import java.util.ArrayList;

import database.SuggboxDB;

public class Idea {

	private  int idIdea; 
	private String ideaText;
	private String ideaTitle;
	private User ideaOwner;
	private ArrayList<Comment> comments;
	private ArrayList<Note> notes;
	
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public ArrayList<Note> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
	public  int getIdIdea() {
		return idIdea;
	}
	public  void createIdea() { // this function must not be called out of the servlet SuggboxDB
		idIdea=SuggboxDB.getInstance().getLastRow("idea")+1;
	}
	public void setIdeaId(int id){
		idIdea=id;
	}

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

package model;

import java.util.ArrayList;

public class Idea {

	private String ideaText;
	private String ideaTitle;
	private User ideaOwner;
	private ArrayList<Comment> comments;
	private Note note;
	
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
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

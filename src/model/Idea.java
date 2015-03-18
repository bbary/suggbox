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
//		StackTraceElement[] e = Thread.currentThread().getStackTrace();
//		if(!e[2].getClassName().equals("servlets.SuggboxDB"))
//			System.out.println("Warning: the caller is not SuggboxDB");
//		for(Idea i: SuggboxDB.getInstance().getAllIdeas())
//			System.out.println(i.getIdeaTitle()+ " "+i.getIdIdea());
//		int lastId=SuggboxDB.getInstance().getAllIdeas().get(SuggboxDB.getInstance().getAllIdeas().size()-1).getIdIdea();
//		System.out.println("id idea "+lastId);
	//	idIdea=lastId+1;
		//System.out.println("id idea "+SuggboxDB.getInstance().getIdea("title idea 1").getIdIdea());
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

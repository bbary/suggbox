package database;
import java.util.ArrayList;

import model.*;

public interface DB {
	void addUser(User u);
	void deleteUser(String login);     //// the database column login is unique
	User getUser(String login);
	
	void addIdea(Idea i);
	void deleteIdea(String ideaTitle);  // the database column title_idea is unique
	void updateIdea(String ideaTitle, Idea idea);
	Idea getIdea(String ideaTitle);
	
	void addComment(Comment c);
	ArrayList<Comment> getComments(String ideaTitle);
	
	void addNote(Note n);
	ArrayList<Note> getNotes(String ideaTitle);
	
	void addGroup(Group p);
	void deleteGroup(String namegroup);
	void getGroup(String namegroup);
	
	void closeConnection();
	
}

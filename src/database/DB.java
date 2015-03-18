package database;
import java.util.ArrayList;

import model.*;

public interface DB {
	//id_user, login, firstname, lastname, id_group
	void addUser(User u);
	void deleteUser(String login);     //// the database column login is unique
	User getUser(String login);
	//ArrayList<Idea> getAllIdeas();
	
	//id_idea, text_idea, title_idea, id_user
	void addIdea(Idea i, User u);
	void deleteIdea(String ideaTitle);  // the database column title_idea is unique
	void updateIdea(String ideaTitle, Idea idea);
	Idea getIdea(String ideaTitle);
	ArrayList<Idea> getAllIdeas();
	
	//id_comment, text_comment, id_idea, id_user
	void addComment(Comment c, User u, Idea i);
	ArrayList<Comment> getComments(String ideaTitle);
	
	//id_note, nbr_stars, id_idea, id_user
	void addNote(Note n);
	Note getNote(int  idNote);
	
	//id_group, name_group, service_group
	void addGroup(Group p);
	void deleteGroup(String namegroup);
	Group getGroup(String namegroup);
	
	int getLastRow(String table);
	void closeConnection();
	
}

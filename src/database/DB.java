package database;
import model.*;

public interface DB {
	void addUser(User u);
	void deleteUser(String login);     //// the database column login is unique
	User getUser(String login);
	
	void addIdea(Idea i);
	void deleteIdea(String ideaTitle);  // the database column title_idea is unique
	void updateIdea(String ideaTitle);
	Idea getIdea(String ideaTitle);
	
	
	void closeConnection();
	
}

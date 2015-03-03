package database;
import model.*;

public interface DB {
	void addUser(User u);
	void deleteUser(User u);
	User getUser(User u);
	
}

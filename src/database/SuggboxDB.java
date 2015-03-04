package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Idea;
import model.Note;
import model.User;

public class SuggboxDB implements DB {

	private Connection connexion = null;
	private Statement statement = null;
	private PreparedStatement stmt = null;

	public SuggboxDB(String dbUrl, String mysqlUser, String password,
			String driver) {
		/* Chargement du driver JDBC pour MySQL */
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			/* Connexion à la base de données */
			connexion = DriverManager.getConnection(dbUrl, mysqlUser, password);

			/* Création de l'objet gérant les requêtes */
			statement = connexion.createStatement();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void addUser(User u) {
		try {

			stmt = connexion
					.prepareStatement("insert into User(login, firstname, lastname) values(?, ?, ?)");
			stmt.setString(1, u.getLogin());
			stmt.setString(1, u.getFirstName());
			stmt.setString(1, u.getLastName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	@Override
	public void deleteUser(String login) {

		try {

			stmt = connexion.prepareStatement("delete from User where login=?");
			stmt.setString(1, login);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	@Override
	public User getUser(String login) {
		User u = new User();
		ResultSet resultat = null;
		try {

			stmt = connexion
					.prepareStatement("SELECT * FROM User where login=?");
			stmt.setString(1, login);
			resultat = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String firstname = null;
		String lastname = null;
		String loginUser = null;
		/* Récupération des données du résultat de la requête de lecture */
		try {

			while (resultat.next()) {
				firstname = resultat.getString("firstname");
				lastname = resultat.getString("lastname");
				loginUser = resultat.getString("firstname");
			}
			u.setFirstName(firstname);
			u.setLastName(lastname);
			u.setLogin(loginUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultat != null)
				try {
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return u;
	}



	@Override
	public void addIdea(Idea i) {
		try {

			stmt = connexion
					.prepareStatement("insert into idea(text_idea, title_idea) values(?, ?)");
			stmt.setString(1, i.getIdeaText());
			stmt.setString(1, i.getIdeaTitle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void deleteIdea(String ideaTitle) {
		try {
			stmt = connexion.prepareStatement("delete from idea where title_idea=?");
			stmt.setString(1, ideaTitle);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void updateIdea(String ideaTitle, Idea new_idea) {
		ResultSet result=null;
		// id_idea, text_idea, title_idea, id_user
		try {
			stmt=connexion.prepareStatement("update idea set text_idea=?, title_idea=? where title_idea=?");
			stmt.setString(1, new_idea.getIdeaText());
			stmt.setString(2, new_idea.getIdeaTitle());
			stmt.setString(3, ideaTitle);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}

	@Override
	public Idea getIdea(String ideaTitle) {
		Idea idea = new Idea();
		ResultSet resultat = null;
		try {

			stmt = connexion
					.prepareStatement("SELECT title_idea, text_idea, login, id_note  FROM idea, User, note where text_idea=? AND User.id_user=idea.id_user AND note.id_note=user.id_user)");
			stmt.setString(1, ideaTitle);
			resultat = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String title = null;
		String text = null;
		User owner=new User();
		Note note=new Note();
		try {

			while (resultat.next()) {
				title = resultat.getString("title_idea");
				text = resultat.getString("text_idea");
				owner = getUser(resultat.getString("login"));
				note  = getNote(resultat.getString("id_note"));
				
			}
			idea.setIdeaText(text);
			idea.setIdeaTitle(title);
			idea.setIdeaOwner(owner);
			idea.setNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultat != null)
				try {
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return idea;
	}
	
	@Override
	public void closeConnection() {
		if (connexion != null)
			try {
				connexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}

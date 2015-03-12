package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Group;
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
					.prepareStatement("insert into User(id_user, login, firstname, lastname) values(?, ?, ?, ?)");
			User.createUser();
			stmt.setInt(1, User.getIdUser());
			stmt.setString(2, u.getLogin());
			stmt.setString(3, u.getFirstName());
			stmt.setString(4, u.getLastName());
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
				loginUser = resultat.getString("login");
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
					.prepareStatement("insert into idea(id_idea, text_idea, title_idea) values(?, ?, ?)");
			Idea.createIdea();
			stmt.setInt(1, Idea.getIdIdea());
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
		ResultSet resultat2 = null;
		try {

			stmt = connexion
					.prepareStatement("select title_idea, text_idea, login from User, idea where idea.title_idea=? AND idea.id_user=User.id_user");
			stmt.setString(1, ideaTitle);
			resultat = stmt.executeQuery();
			PreparedStatement stmt2=connexion.prepareStatement("select id_note, title_idea, text_idea, login, nbr_stars from User, note, idea where idea.title_idea=? AND idea.id_user=User.id_user AND idea.id_idea=note.id_idea");
			stmt2.setString(1, ideaTitle);
			
			resultat2 = stmt2.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String title = null;
		String text = null;
		User owner=new User();
		int idNote=0;
		ArrayList<Note> notes=new ArrayList<Note>();
		try {

			while (resultat.next()) {
				title = resultat.getString("title_idea");
				text  = resultat.getString("text_idea");
				owner = getUser(resultat.getString("login"));
				
				
			}
			while (resultat2.next()) {
				idNote=resultat2.getInt("id_note");
				notes.add(getNote(idNote));												
			}
			
			idea.setIdeaText(text);
			idea.setIdeaTitle(title);
			idea.setIdeaOwner(owner);
			idea.setNotes(notes);
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
	public void addComment(Comment comment) {
		try {
			stmt = connexion
					.prepareStatement("insert into comment(id_comment, text_comment, id_idea, id_user) values(?, ?, ?, ?)");
			Comment.createComment();  // increment id    
			stmt.setInt(1, Comment.getIdComment()); 
			stmt.setString(2, comment.getComment());
			stmt.setInt(3, comment.getCommentedIdea().getIdIdea());
			stmt.setInt(4, comment.getCommentator().getIdUser());
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
	public ArrayList<Comment> getComments(String ideaTitle) {
		ArrayList<Comment> comments=new ArrayList<Comment>();
		ResultSet res=null;
		try {
			stmt=connexion.prepareStatement("select id_comment, text_comment, title_idea, login from comment,idea, User where comment.id_idea=idea.id_idea AND idea.title_idea=? AND comment.id_user=User.id_user;");
			stmt.setString(1, ideaTitle);
			res=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		while(res.next()){
			Comment com=new Comment();
			com.setComment(res.getString("text_comment"));
			com.setCommentedIdea(getIdea(res.getString("title_idea")));
			com.setCommentator(getUser(res.getString("login")));
			comments.add(com);
					
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (res != null)
				try {
					res.close();
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
		return comments;

	}

	@Override
	public void addNote(Note note) {
		try {
			stmt = connexion
					.prepareStatement("insert into note(id_note, nbr_stars, id_idea, id_user) values(?, ?, ?, ?)");
			note.createNote();  // increment id    
			stmt.setInt(1, note.getIdNote()); 
			stmt.setInt(2, note.getStars());
			stmt.setInt(3, note.getIdea().getIdIdea());
			stmt.setInt(4, note.getEvaluator().getIdUser());
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
	public Note getNote(int idNote) {
		Note note=new Note();
		ResultSet result=null;
		try {
			stmt=connexion.prepareStatement("select id_note, login, title_idea from note, User, idea where id_note=? AND User.id_user=note.id_user AND idea.id_idea=note.id_idea");
			stmt.setInt(1, idNote);
			result=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			note.setEvaluator(getUser(result.getString("login")));
			note.setIdea(getIdea(result.getString("title_idea")));
			note.setStars(result.getInt("nbr_stars"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(result!=null)
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return note;		
	}

	@Override
	public void addGroup(Group group) {

		try {
			stmt = connexion
					.prepareStatement("insert into Group(id_group, name_group, service_group) values(?, ?, ?)");
			group.createGroup();  // increment id    
			stmt.setInt(1, group.getIdGroup()); 
			stmt.setString(2, group.getName());
			stmt.setString(3, group.getService());
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
	public void deleteGroup(String namegroup) {
		try {
			stmt = connexion.prepareStatement("delete from Group where name=?");
			stmt.setString(1, namegroup);
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
	public Group getGroup(String namegroup) {
		Group group=new Group();
		
		ResultSet result=null;
		try {
			stmt=connexion.prepareStatement("select name_group, service_group from Group where name_group=?");
			stmt.setString(1, namegroup);
			result=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			group.setName(result.getString("name_group"));
			group.setService(result.getString("service_group"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(result!=null)
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return group;
		
	}
	
	@Override
	public ArrayList<Idea> getAllIdeas() {
		ArrayList<Idea> ideas=new ArrayList<Idea>();
		ResultSet result=null;
		try {
			stmt=connexion.prepareStatement("select title_idea from idea");
			result=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(result.next()){
				ideas.add(getIdea(result.getString("title_idea")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ideas;
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

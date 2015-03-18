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

public final class SuggboxDB implements DB {

	private Connection connexion = null;
	private Statement statement = null;
	private PreparedStatement stmt = null;
	private static volatile SuggboxDB instance = null;
	
	  private SuggboxDB() {
		  super();
    		String dbUrl = "jdbc:mysql://localhost:3306/suggboxDB";
			String mysqlUser = "root";				
			String password = "thatismypath";	
			String driver="com.mysql.jdbc.Driver";
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

	  public final static SuggboxDB getInstance() {
	         if (SuggboxDB.instance == null) {
	         
	            synchronized(SuggboxDB.class) {
	              if (SuggboxDB.instance == null) {
	            	  SuggboxDB.instance = new SuggboxDB();
	              }
	            }
	         }
	         return SuggboxDB.instance;
	     }


	@Override
	public void addUser(User u) {
		try {
			stmt = connexion
					.prepareStatement("insert into User(id_user, login, firstname, lastname) values(?, ?, ?, ?)");
			u.createUser();
			stmt.setInt(1, u.getIdUser());
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
		int idUser=0;
		String firstname = null;
		String lastname = null;
		String loginUser = null;
		/* Récupération des données du résultat de la requête de lecture */
		try {

			while (resultat.next()) {
				idUser=resultat.getInt("id_user");
				firstname = resultat.getString("firstname");
				lastname = resultat.getString("lastname");
				loginUser = resultat.getString("login");
			}
			u.setIdUser(idUser);
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
			else
				u=null;
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
	public void addIdea(Idea i, User u) {
		try {

			stmt = connexion
					.prepareStatement("insert into idea(id_idea, text_idea, title_idea, id_user) values(?, ?, ?, ?)");
			i.createIdea();
			System.out.println("i.getIdIdea() "+i.getIdIdea());
			stmt.setInt(1, i.getIdIdea());
			stmt.setString(2, i.getIdeaText());
			stmt.setString(3, i.getIdeaTitle());
			stmt.setInt(4, u.getIdUser());
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
					.prepareStatement("select id_idea, title_idea, text_idea, login from User, idea where idea.title_idea=? AND idea.id_user=User.id_user");
			stmt.setString(1, ideaTitle);
			resultat = stmt.executeQuery();
			PreparedStatement stmt2=connexion.prepareStatement("select id_note, title_idea, text_idea, login, nbr_stars from User, note, idea where idea.title_idea=? AND idea.id_user=User.id_user AND idea.id_idea=note.id_idea");
			stmt2.setString(1, ideaTitle);
			
			resultat2 = stmt2.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int idIdea=0;
		String title = null;
		String text = null;
		User owner=new User();
		int idNote=0;
		ArrayList<Note> notes=new ArrayList<Note>();
		ArrayList<Comment> comments=new ArrayList<Comment>();
		comments=getComments(ideaTitle);
		try {

			while (resultat.next()) {
				idIdea=resultat.getInt("id_idea");
				title = resultat.getString("title_idea");
				text  = resultat.getString("text_idea");
				owner = getUser(resultat.getString("login"));
				
				
			}
			while (resultat2.next()) {
				idNote=resultat2.getInt("id_note");
				notes.add(getNote(idNote));												
			}
			idea.setIdeaId(idIdea);
			idea.setIdeaText(text);
			idea.setIdeaTitle(title);
			idea.setIdeaOwner(owner);
			idea.setNotes(notes);
			idea.setComments(comments);
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
	public void addComment(Comment comment, User user, Idea i) {
		try {
			stmt = connexion
					.prepareStatement("insert into comment(id_comment, text_comment, id_idea, id_user) values(?, ?, ?, ?)");
			comment.createComment();  // increment id    
			stmt.setInt(1, comment.getIdComment()); 
			stmt.setString(2, comment.getComment());
			stmt.setInt(3, i.getIdIdea());
			stmt.setInt(4, user.getIdUser());
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
			com.setIdComment(res.getInt("id_comment"));
			com.setComment(res.getString("text_comment"));
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
					.prepareStatement("insert into note(id_note, nbr_stars) values(?, ?)");
			note.createNote();  // increment id    
			stmt.setInt(1, note.getIdNote()); 
			stmt.setInt(2, note.getStars());
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
			stmt=connexion.prepareStatement("select id_note, nbr_stars from note where id_note=?");
			stmt.setInt(1, idNote);
			result=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result.next();
			note.setStars(result.getInt("nbr_stars"));
			note.setIdNote(result.getInt("id_note"));
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
			stmt=connexion.prepareStatement("select id_group, name_group, service_group from Group where name_group=?");
			stmt.setString(1, namegroup);
			result=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			group.setIdGroup(result.getInt("id_group"));
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

	@Override
	public int getLastRow(String tab)  {
		int r=-1;
		
		String table=null;
		String column=null;
		if(tab.equals("user")){
			table="User";
			column="id_user";
		}
		else if(tab.equals("group")){
			table="Group";
			column="id_group";
		}
		else if(tab.equals("idea")){
			table="idea";
			column="id_idea";
		}
		else if(tab.equals("comment")){
			table="comment";
			column="id_comment";
		}
		else if(tab.equals("note")){
			table="note";
			column="id_note";
		}
			
		ResultSet res=null;
		//stmt=connexion.prepareStatement("select "+column+" from "+table+" order by "+column+" desc limit 1");
		try {
			
			
			res=statement.executeQuery("select "+column+" from "+table+" order by "+column+" desc limit 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			res.next();
			r=res.getInt(column);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
		
	}
}

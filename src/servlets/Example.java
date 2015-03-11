package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Note;
import model.User;
import database.SuggboxDB;

public class Example extends HttpServlet {

	//public static final String ATT_MESSAGES = "messages";
	//public static final String VUE = "/WEB-INF/test_jdbc.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		/* Initialisation de l'objet Java et récupération des messages */
		String url = "jdbc:mysql://localhost:3306/suggboxDB";
		String utilisateur = "root";
		String motDePasse = "thatismypath";
		String jdbcDriver="com.mysql.jdbc.Driver";
		SuggboxDB suggbox = new SuggboxDB(url, utilisateur, motDePasse, jdbcDriver);
		/*
		 * interaction avec le model (base de données) à travers la classe SuggboxDB
		 * 
		 */
		User u=new User();
		u.createUser();
		
		suggbox.closeConnection();
		
		
		//request.setAttribute(ATT_MESSAGES, messages);

		/* Transmission vers la page en charge de l'affichage des résultats */
//		this.getServletContext().getRequestDispatcher(VUE)
//				.forward(request, response);
	}
}
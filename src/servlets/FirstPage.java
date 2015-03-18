package servlets;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import model.User;
import database.SuggboxDB;


public class FirstPage extends HttpServlet {
		    private static final long serialVersionUID = 1L;

//		    public void doGet(HttpServletRequest request, HttpServletResponse response)
//    				throws ServletException, IOException {
//    			RequestDispatcher dispatcher = null;
//    			dispatcher = request.getRequestDispatcher("login.jsp");
//    			dispatcher.forward(request, response);
//    	    }
    	 
    	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    	//System.out.println("last row "+SuggboxDB.getInstance().getLastRow("idea"));
    	    	HttpSession session = request.getSession(); 
    	        String login = request.getParameter("login");

    	        RequestDispatcher dispatcher = null;
    			
    			User user=new User();
    			user=SuggboxDB.getInstance().getUser(login);
    			session.setAttribute("user", user);
    			//System.out.println("login "+user.getLogin());		
    			
    	        if(user.getLogin()!=null){
    	            dispatcher = request.getRequestDispatcher("create.jsp");
    	            request.setAttribute("login", user.getLogin());
    	            
    	        }
    	        else{
    	            dispatcher = request.getRequestDispatcher("login.jsp");
    	            String msg2 = "Hello " + login +" Your login is failed";
    	            request.setAttribute("messagerreur", msg2);
    	        }
    	        dispatcher.forward(request, response);
    	        //SuggboxDB.getInstance().closeConnection();
    	        }
    	    }    	

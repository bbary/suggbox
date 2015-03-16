package servlets;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class FirstPage extends HttpServlet {
	
    	  	private String paramLogin;
    	    private String paramPassword;
    	     
    	    public void init() throws ServletException {
    	        this.paramLogin = "zero";
    	        this.paramPassword = "zero";
    	    }
    	    private static final long serialVersionUID = 1L;

    	 
    	    /**
    	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	     */
    		public void doGet(HttpServletRequest request, HttpServletResponse response)
    				throws ServletException, IOException {
    			RequestDispatcher dispatcher = null;
    			dispatcher = request.getRequestDispatcher("login.jsp");
    			dispatcher.forward(request, response);
    	    }
    	 
    	    /**
    	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	     */
    	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	    	
    	        String login = request.getParameter("login");
    	        String pwd = request.getParameter("pwd");
    	         
    	        RequestDispatcher dispatcher = null;
    	        
    	        if(this.paramLogin.equalsIgnoreCase(login) && this.paramPassword.equalsIgnoreCase(pwd)){
    	            dispatcher = request.getRequestDispatcher("create.jsp");
    	             String msg1 = "Hello " + login +" Your login is sucessful";
    	            request.setAttribute("messagerreur", msg1);
    	            System.out.println("affichage ok ");
    	        }
    	        else{
    	            dispatcher = request.getRequestDispatcher("login.jsp");
    	            String msg2 = "Hello " + login +" Your login is failed";
    	            request.setAttribute("messagerreur", msg2);
    	        }
    	        dispatcher.forward(request, response);
    	        }
    	    }    	

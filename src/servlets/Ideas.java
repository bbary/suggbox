package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Idea;
import model.User;
import database.SuggboxDB;

public class Ideas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ideas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		
		String title = request.getParameter("title");
		    String text = request.getParameter("text");
	        User ideaOwner= new User();
	        HttpSession session = request.getSession(false);
	        
	        ideaOwner=(User) session.getAttribute("user");
	        if(ideaOwner.getLogin()!=null){
		    RequestDispatcher dispatcher = null;
			
			Idea idea=new Idea();
			//idea.setIdeaOwner(ideaOwner);
			idea.setIdeaText(text);
			idea.setIdeaTitle(title);
			SuggboxDB.getInstance().addIdea(idea);
			
	            dispatcher = request.getRequestDispatcher("create.jsp");
	            String success = "the idea is added successfully";
	            request.setAttribute("success", success);
	        
	        dispatcher.forward(request, response);
	        }
	        
	        
	}

}

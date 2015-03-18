package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Idea;
import model.User;
import database.SuggboxDB;

public class Comments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Comment> comments=SuggboxDB.getInstance().getComments(request.getParameter("ideaTitle"));
		
		
		Idea commentedIdea=SuggboxDB.getInstance().getIdea(request.getParameter("ideaTitle"));
		HttpSession session = request.getSession();
		session.setAttribute("comments", comments);
		session.setAttribute("idea", commentedIdea);
		session.setAttribute("nbr_comments", (SuggboxDB.getInstance().getComments(request.getParameter("ideaTitle")).size()));
		request.setAttribute("idea", commentedIdea);
		request.setAttribute("nbr_comments", (SuggboxDB.getInstance().getComments(request.getParameter("ideaTitle")).size()));
		request.setAttribute("comments", comments);
		RequestDispatcher dispatcher=request.getRequestDispatcher("comment.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commentatorLogin = request.getParameter("author");
	    String com = request.getParameter("comment");
        User commentator= SuggboxDB.getInstance().getUser(commentatorLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment.jsp");
        
        
        String success = "Unknown user";
        
        HttpSession session = request.getSession(false);
        Idea commentedIdea=(Idea)session.getAttribute("idea");
		request.setAttribute("idea", session.getAttribute("idea"));
		request.setAttribute("nbr_comments", session.getAttribute("nbr_comments"));
		request.setAttribute("comments", session.getAttribute("comments"));
		
		if(commentator.getLogin()!=null){
		Comment comment=new Comment();
		comment.setComment(com);
		comment.setCommentator(commentator);
		
		SuggboxDB.getInstance().addComment(comment, commentator, commentedIdea);
		     
            success = "the comment is added successfully";
            
		}
		//ArrayList<Comment> coms=(ArrayList<Comment>)session.getAttribute("comments");
		request.setAttribute("success", success);
        dispatcher.forward(request, response);
		
	}

}

package model;

import java.io.Serializable;

import database.SuggboxDB;

public class Comment {
    
	private int idComment;
	private String comment;
	
	private User commentator;
	
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public  void createComment() { // this function must not be called out of the servlet SuggboxDB
		idComment=SuggboxDB.getInstance().getLastRow("comment")+1;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getCommentator() {
		return commentator;
	}
	public void setCommentator(User commentator) {
		this.commentator = commentator;
	}
	
}

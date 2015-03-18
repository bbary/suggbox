package model;

public class Comment {
	private int idComment;
	private String comment;
	private Idea commentedIdea;
	private User commentator;
	

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public static void createComment() { // this function must not be called out of the servlet SuggboxDB
//		StackTraceElement[] e = Thread.currentThread().getStackTrace();
//
//		if(!e[2].getClassName().equals("servlets.SuggboxDB"))
//			System.out.println("Warning: the caller is not SuggboxDB");
//		idComment++;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Idea getCommentedIdea() {
		return commentedIdea;
	}
	public void setCommentedIdea(Idea commentedIdea) {
		this.commentedIdea = commentedIdea;
	}
	public User getCommentator() {
		return commentator;
	}
	public void setCommentator(User commentator) {
		this.commentator = commentator;
	}
	
}

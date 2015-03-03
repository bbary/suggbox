package model;

public class Comment {
	private String comment;
	private Idea commentedIdea;
	private User commentator;
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

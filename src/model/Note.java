package model;

public class Note {
	private static int idNote=0;
	private int stars;
	private Idea idea;
	private User evaluator;
	
	
	public static int getIdNote() {
		return idNote;
	}
	public static void createNote() { // this function must not be called out of the servlet SuggboxDB
		StackTraceElement[] e = Thread.currentThread().getStackTrace();

		if(!e[2].getClassName().equals("servlets.SuggboxDB"))
			System.out.println("Warning: the caller is not SuggboxDB");
		idNote++;
	}
	
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public Idea getIdea() {
		return idea;
	}
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	public User getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(User evaluator) {
		this.evaluator = evaluator;
	}
	
	
}

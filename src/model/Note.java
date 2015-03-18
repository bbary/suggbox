package model;

public class Note {
	private int idNote;
	private int stars;
	private Idea idea;
	private User evaluator;
	
	
	
	public int getIdNote() {
		return idNote;
	}

	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	public  void createNote() { // this function must not be called out of the servlet SuggboxDB
//		StackTraceElement[] e = Thread.currentThread().getStackTrace();
//
//		if(!e[2].getClassName().equals("servlets.SuggboxDB"))
//			System.out.println("Warning: the caller is not SuggboxDB");
//		idNote++;
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

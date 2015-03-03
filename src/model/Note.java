package model;

public class Note {

	private int stars;
	private Idea idea;
	private User evaluator;
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

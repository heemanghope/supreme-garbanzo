package exam04;

public class Grade {
	private String name;
	private double score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade(String name) {
		super();
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public Grade(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	
}

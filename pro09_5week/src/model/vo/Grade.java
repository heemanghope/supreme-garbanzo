package model.vo;

import exception.GradeLevelException;
import exception.GradeScoreException;




public class Grade extends Subject {
	private double score;
	private char level;
	private char[] levelArr = new char[] {
			'F', 'F', 'F', 'F', 'E', 'E', 'D', 'C', 'B', 'A', 'A'
	};
	
	public Grade(String name) {
		super(name);
		this.level = 'F';
	}
	
	public Grade(String name, double score) {
		super(name);
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if(!(score >= 0 && score <= 100)) {
			throw new GradeScoreException("점수의 범위는 0 ~ 100 사이로만 사용해야 합니다.");
		}
		this.score = score;
		this.level = levelArr[(int)(score / 10)];
	}

	public char getLevel() {
		return level;
	}


	public void setLevel(char level) throws GradeLevelException {
		if(!(level >= 'A' && level <= 'F')) {
			throw new GradeLevelException("등급은 'A' ~ 'F' 사이로만 설정하세요.");
		}
		this.level = level;
	}
	
}
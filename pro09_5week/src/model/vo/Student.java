package model.vo;

import java.util.Random;

public class Student extends Account {
	private String name;
	private String password;
	private Grade[] grades;
	
	public Student(String name) {//생성자 this.name=name;
		setName(name);
		setPassword("1111");
	}
	
	public void setPassword(String password) {
		this.password=password;
		
		
	}

	public Student(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public Grade[] getGrades() {
		return grades;
	}
	
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}
	
	public String resetPassword() {
		Random r = new Random();
		String prefix = "STD_";//student
		String newPass = "";
		for(int i = 0; i < 6; i++) {
			newPass += (char)(r.nextInt(26) + 65);
		}
		setPassword(prefix + newPass);
		return prefix + newPass;
	}
	
}

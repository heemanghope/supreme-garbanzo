package exam02;

import java.util.Arrays;

public class ReportGrade {
	private String name;
	private String[] subjects;
	private double[] grades;

	public ReportGrade(String name) {
		this.name = name;
	}

	public ReportGrade(String name, String[] subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	public void setGrades(String subject, double grade) {
		int idx = this._findIndex(subject);
		this.grades[idx] = grade;//과목배열의 인덱스와 점수배열의 인덱스가 서로 동일한 인덱스 //국어 과목의 인덱스가 
	}//0번이면 점수 0번  //방금한것과 같이(48줄) 호출만 시키는 걸로 변형.//코드가 확실히 줄어든다.
	
	public double getGrade(String subject) {
		int idx = this._findIndex(subject); //97번째줄 findindex에서 동일한 과목명을 찾아 index에 저장
		return this.grades[idx]; // 호출만 시켜준다
	}
	
	public void add(String subject, double grade) {//정보 추가이므로 return해줄거는 없음
		int len = this.subjects.length;//동적배열을 활용하는것. 
		this.subjects = Arrays.copyOf(this.subjects, len + 1); //this.subjects.length+`1을 줄인것임.
		this.grades = Arrays.copyOf(this.grades, len + 1);
		
		this.subjects[len] = subject;
		this.grades[len] = grade;
	}
	
	public void remove(String subject) {
		// 기본 배열에 저장되어 있는 과목 정보와 점수 정보를 삭제.
		// 배열에 없는 과목명의 경우. "해당 과목이 존재하지 않습니다." 출력
		
		int index = this._findIndex(subject);
		if(index == -1) {
			System.out.println("해당 과목이 존재하지 않습니다.");
		}
		this.remove(index); //-1이 아니면 remove index
	}
	
	public void remove(int index) {
		// 기본 배열에 저장되어 있는 과목 정보와 점수 정보를 삭제.
		// 인덱스의 범위를 벗어나는 경우. "인덱스의 범위를 벗어났습니다." 출력
		
		if(index >= this.subjects.length && index < 0) {
			System.out.println("인덱스의 범위를 벗어났습니다.");
			return;	// return이 되는 순간 메서드는 종료 !!
		}
		
		String[] temp1 = new String[this.subjects.length - 1]; //temp는 (=새로운 공간,임시변수) -1하나삭제된것.subjects=과목
		double[] temp2 = new double[this.grades.length - 1];//성적정보,grades
		int idx = 0; //외부의 별도 idx를 만듬
		
		for(int i = 0; i < this.subjects.length; i++) {
			if(i != index) {//내가 찾고자하는 i와 다를때
				temp1[idx] = this.subjects[i];
				temp2[idx] = this.grades[i];
				idx++;
			}
		}
		this.subjects = temp1; //기존의 subjects에다가 얕은복사 시켜야함.
		this.grades = temp2;//기존의 grades에다가 얕은복사 시켜야함.
	}
	
	private int _findIndex(String subject) {
		int idx = -1;
		for(int i = 0; i < this.subjects.length; i++) {
			String s = this.subjects[i];
			if(subject.equals(s)) {
				idx = i;	// 동일한 과목명을 찾아서 인덱스 저장
				break;
			}
		}
		return idx;
	}
}

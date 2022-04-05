package exam02;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		ReportGrade report = new ReportGrade("홍길동");
		String[] subjects = new String[] {
				"국어", "영어", "수학", "과학"
		};
		double[] grades = new double[] {
				76.8, 84.2, 93.3, 87.8
		};
		report.setSubjects(subjects);
		report.setGrades(grades);
		
		report.setGrades("영어", 88.5); // set은 설정해라. 영어를 88.5로!
		
		
		String[] s = report.getSubjects();
		double[] g = report.getGrades();
		
		for(int i = 0; i < s.length; i++) {  //별도의 변수에 저장을 시킨다.
			System.out.println(s[i] + ": " + g[i] + " 점");
		}                    //s에 i번째 해당하는게 과목명  g에 i번쨰가 점수화 되는것. //어떠한 과목이 몇점 받음을 알수있다.
		
		System.out.println(report.getGrade("국어")); //배열에 대한 참조값. 반환되는 형태보다는 "과목"에 대한 점수를 알고 싶다.
		System.out.println(report.getGrade("수학"));
		System.out.println(report.getGrade("과학"));
		
		report.add("사회", 92.4);	// 배열에 해당 정보를 추가
		System.out.println(report.getGrade("사회"));
		
		System.out.println(Arrays.toString(report.getSubjects()));//2번에 index에 있는 과목을 지우기 전에 출력하고
		report.remove(2); //Arrays.toString 배열에서 배열내용이 출력한다.//자바에서 배열의 변수 그대로 출력하게 되면 배열의 주소값이 출력됩니다.
		System.out.println(Arrays.toString(report.getSubjects()));//2번 지우고 나서 출력하고!
		report.remove("과학");
		System.out.println(Arrays.toString(report.getSubjects()));
		
		
		Page page = new Page( 100);
		//현재 페이지번호를 보고 싶다면??
		for(int i = 0; i < page.getLimitPageNumber(); i++) {
			page.nextPage();
			System.out.println(page.getPageNumber() + " 페이지 입니다.");  //일정 횟수만큼 반복하는것
		}
		
		while(page.existsPrevPage()) {
			page.prevPage();
			System.out.println(page.getPageNumber() + " 페이지 입니다.");//마지막페이지(100)에서부터 (1)로 
		}
	}

}

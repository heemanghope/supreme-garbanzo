package exam04;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		/*
		 * Grade 에는 과목에 대한 성적 정보가 있는 객체
		 * 
		 * GradeList 에는 Grade 를 배열로 관리하는 객체
		 *          - 과목에 대한 성적 관리를 위해 Grade 객체를 추가 / 수정/ 삭제 /조회
		 *            할 수 있는 기능을 만든다.
		 *          
		 *          - 
		 */
		
		//데이터를 배열에 담아서 추가 삭제 수정 조회하는것임.................................
//	GradeList data =new GradeList();
	//datas.add(new Grade("국어",67.8));
//	System.out.println("국어 : " +datas.getScore("국어"));
			
	
	//    Grade g = datas.getGrade(0);
	//    g.setName("영어"); g.setScore(78.7);
	//    System.out.println("영어 : " + g.getScore());
	   //참조라는 형상으로 이렇게 나옴.
	   //객체를 새로 만들어주면 참조값이 바뀐다.  //바뀌는걸 원치않아서 ㄱ대로 둔다.
     
	
	GradeList datas =new GradeList();
	datas.add("영어", 56);
	datas.add("국어", 37);
	datas.add("수학", 67);
	datas.add("과학", 39);
	
	
	System.out.println(Arrays.toString(datas.getUnder()));
	System.out.println(Arrays.toString(datas.getUnder(60)));
	System.out.println(datas.getTop());
	System.out.println(datas.getTop());
	System.out.println(Arrays.toString(datas.getTop(2)));
	System.out.println(datas.getBottom());
	System.out.println(Arrays.toString(datas.getBottom(2)));
}

}
	
	
	
	
	